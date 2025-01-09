package com.barley.training.biz.service.admin.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.common.base.exception.BusinessException;
import com.barley.training.biz.channel.ItcApis;
import com.barley.training.biz.channel.request.LiveRequest;
import com.barley.training.biz.channel.request.VideoListRequest;
import com.barley.training.biz.channel.response.*;
import com.barley.training.biz.entity.Course;
import com.barley.training.biz.entity.ProjectClass;
import com.barley.training.biz.mapper.CourseMapper;
import com.barley.training.biz.service.admin.CourseService;
import com.barley.training.biz.service.admin.ProjectClassService;
import com.barley.training.biz.service.convert.CourseConvertMapper;
import com.barley.training.stub.biz.bean.admin.*;
import com.barley.training.stub.biz.request.CourseRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.barley.common.base.constants.Constants.LIMIT_1;

@Log4j2
@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    private final ProjectClassService projectClassService;
    private final ItcApis itcApis;

    @Override
    public boolean saveBy(CourseRequest request) {
        Course entity = CourseConvertMapper.INSTANCE.toEntity(request);
        return this.saveOrUpdate(entity);
    }

    @Override
    public boolean removeBy(long id) {
        Course course = this.getById(id);
        if (Objects.nonNull(course.getLiveId())) {
            throw new BusinessException("1003", "请先删除录播预约");
        }
        return this.lambdaUpdate().set(Course::getIsDelete, true)
                .eq(Course::getId, id)
                .last(LIMIT_1)
                .update();
    }

    @SneakyThrows
    @Override
    public Boolean liveById(long id) {
        Course entity = this.getById(id);
        if (Objects.nonNull(entity.getLiveId())) {
            throw new BusinessException("1001", "已申请预约录播");
        }
        LiveRequest req = new LiveRequest();
        req.setName(entity.getCourseName());
        req.setRecorder_id(1);
        req.setIs_record(1);
        String[] times = entity.getTime().split("~");
        req.setStart_time(entity.getDate() + " " + times[0].trim() + ":00");
        req.setEnd_time(entity.getDate() + " " + times[1].trim() + ":00");
        LiveResponse live = itcApis.live(req);
        Optional.ofNullable(live)
                .map(LiveResponse::getData)
                .map(LiveResponse.Data::getId)
                .ifPresent(entity::setLiveId);
        return this.updateById(entity);
    }

    @SneakyThrows
    @Override
    public LiveDetailDTO liveDetailById(long id) {
        Course course = this.getById(id);
        LiveDetailDTO liveDetailDTO = new LiveDetailDTO();
        if (Objects.nonNull(course.getLiveId())) {
            LiveDetailResponse liveDetailResponse = itcApis.liveDetail(String.valueOf(course.getLiveId()));
            LiveDetailResponse.LiveData liveData = liveDetailResponse.getData().getData();
            liveDetailDTO.setLiveId(liveData.getId());
            liveDetailDTO.setPlayUrl(liveData.getPlayUrl());
            liveDetailDTO.setIsRecord(liveData.getIsRecord());
            liveDetailDTO.setH5Url(liveData.getH5Url());
            liveDetailDTO.setM3u8Url(liveData.getM3u8Url());
            liveDetailDTO.setRecordStatus(liveData.getRecordStatus());
            liveDetailDTO.setStatusCode(liveData.getStatusCode());
            liveDetailDTO.setCreateTime(liveData.getCreateTime());
            liveDetailDTO.setStartTime(liveData.getStartTime());
            liveDetailDTO.setEndTime(liveData.getEndTime());
            liveDetailDTO.setExamineStatusText(liveData.getExamineStatusText());
        }
        return liveDetailDTO;
    }

    @SneakyThrows
    @Override
    public Boolean deleteLiveById(long id) {
        Course entity = this.getById(id);
        if (Objects.isNull(entity.getLiveId())) {
            throw new BusinessException("1002", "当前计划没有预约录播");
        }
        itcApis.liveDelete(entity.getLiveId());

        return this.lambdaUpdate().set(Course::getLiveId, null)
                .eq(Course::getId, entity.getId()).update();
    }

    @Override
    public List<CourseListDTO> listByProject(long id) {
        List<Course> courses = this.lambdaQuery().eq(Course::getProjectId, id).list();
        if (courses.isEmpty()) {
            return List.of();
        }
        List<Long> classIds = courses.stream().map(Course::getClassId).distinct().toList();
        List<ProjectClass> projectClasses = projectClassService.lambdaQuery().in(ProjectClass::getId, classIds).list();
        Map<Long, String> classMap = projectClasses.stream().collect(Collectors.toMap(ProjectClass::getId, ProjectClass::getClassName));
        Map<Long, List<Course>> courseMap = courses.stream().collect(Collectors.groupingBy(Course::getClassId));
        List<CourseListDTO> courseListDTOS = new ArrayList<>(List.of());
        courseMap.forEach((k, v) -> {
            List<CourseListDTO> courseList = v.stream().map(d -> CourseListDTO.builder().key(String.valueOf(d.getId())).label(d.getCourseName()).build()).toList();
            CourseListDTO projectClass = CourseListDTO.builder().key(String.valueOf(k)).label(classMap.get(k)).children(courseList).build();
            courseListDTOS.add(projectClass);
        });
        return courseListDTOS;
    }

    @SneakyThrows
    @Override
    public List<CourseViewDTO> videoByCourseId(long id) {
        Course entity = this.getById(id);
        if (Objects.isNull(entity) || Objects.isNull(entity.getLiveId())) {
            return List.of();
        }
        VideoListRequest request = new VideoListRequest();
        request.setLive_id(entity.getLiveId());
        request.setPage_index(1);
        request.setPage_size(100);
        VideoListResponse res = itcApis.videoList(request);
        return Optional.ofNullable(res.getData())
                .map(data -> Optional.ofNullable(data.getData())
                        .map(data2 -> Optional.ofNullable(data2.getData())
                                .map(data3 -> data3.stream()
                                        .map(video -> {
                                            CourseViewDTO courseViewDTO = new CourseViewDTO();
                                            courseViewDTO.setId((long) video.getId());
                                            courseViewDTO.setVideoName(video.getVideoName());
                                            courseViewDTO.setVideoUrl(video.getVideoUrl());
                                            courseViewDTO.setPlayUrl(video.getPlayUrl());
                                            courseViewDTO.setRtmpUrl(video.getRtmpUrl());
                                            return courseViewDTO;
                                        })
                                        .toList())
                                .orElse(Collections.emptyList()))
                        .orElse(Collections.emptyList()))
                .orElse(Collections.emptyList());

    }
}
