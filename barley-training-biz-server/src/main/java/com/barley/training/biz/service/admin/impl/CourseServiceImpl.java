package com.barley.training.biz.service.admin.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.common.base.exception.BusinessException;
import com.barley.training.biz.channel.ItcApis;
import com.barley.training.biz.channel.request.LiveRequest;
import com.barley.training.biz.channel.response.LiveDetailResponse;
import com.barley.training.biz.channel.response.LiveResponse;
import com.barley.training.biz.entity.Course;
import com.barley.training.biz.mapper.CourseMapper;
import com.barley.training.biz.service.admin.CourseService;
import com.barley.training.biz.service.convert.CourseConvertMapper;
import com.barley.training.stub.biz.bean.admin.LiveDetailDTO;
import com.barley.training.stub.biz.request.CourseRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

import static com.barley.common.base.constants.Constants.LIMIT_1;

@Log4j2
@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

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
            throw new BusinessException("1001", "你以申请预约录播");
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
            liveDetailDTO.setId(liveData.getId());
            liveDetailDTO.setPlayUrl(liveData.getPlayUrl());
            liveDetailDTO.setIsRecord(liveData.getIsRecord());
            liveDetailDTO.setH5Url(liveData.getH5Url());
            liveDetailDTO.setM3u8Url(liveData.getM3u8Url());
            liveDetailDTO.setRecordStatus(liveData.getRecordStatus());
            liveDetailDTO.setStatusCode(liveData.getStatusCode());
            liveDetailDTO.setCreateTime(liveData.getCreateTime());
            liveDetailDTO.setStartTime(liveData.getStartTime());
            liveDetailDTO.setEndTime(liveData.getEndTime());
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
        entity.setLiveId(null);
        return this.updateById(entity);
    }
}
