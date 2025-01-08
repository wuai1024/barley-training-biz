package com.barley.training.biz.service.admin.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.training.biz.channel.ItcApis;
import com.barley.training.biz.channel.request.LiveRequest;
import com.barley.training.biz.channel.response.LiveResponse;
import com.barley.training.biz.entity.Course;
import com.barley.training.biz.mapper.CourseMapper;
import com.barley.training.biz.service.admin.CourseService;
import com.barley.training.biz.service.convert.CourseConvertMapper;
import com.barley.training.stub.biz.request.CourseRequest;
import lombok.RequiredArgsConstructor;
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
        LiveRequest req = new LiveRequest();
        req.setName(request.getCourseName());
        req.setRecorder_id(1);
        req.setIs_record(1);
        String[] times = request.getTime().split("~");
        req.setStart_time(request.getDate() + " " + times[0]);
        req.setEnd_time(request.getDate() + " " + times[1]);
        Course entity = CourseConvertMapper.INSTANCE.toEntity(request);
        try {
            LiveResponse live = itcApis.live(req);
            Optional.ofNullable(live)
                    .map(LiveResponse::getData)
                    .map(LiveResponse.DataContainer::getData)
                    .map(LiveResponse.DeviceData::getId)
                    .ifPresent(entity::setLiveId);
        } catch (Exception e) {
            log.error("[直播预约] 失败: {}", e.getMessage(), e);
        }

        return this.saveOrUpdate(entity);
    }

    @Override
    public boolean removeBy(long id) {
        Course course = this.getById(id);
        try {
            if (Objects.nonNull(course.getLiveId())) {
                itcApis.liveDelete(course.getLiveId());
            }
        } catch (Exception e) {
            log.error("[直播删除] 失败: {}", e.getMessage(), e);
        }
        return this.lambdaUpdate().set(Course::getIsDelete, true)
                .eq(Course::getId, id)
                .last(LIMIT_1)
                .update();
    }
}
