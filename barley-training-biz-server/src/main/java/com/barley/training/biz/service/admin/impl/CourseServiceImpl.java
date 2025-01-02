package com.barley.training.biz.service.admin.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.training.biz.entity.Course;
import com.barley.training.biz.mapper.CourseMapper;
import com.barley.training.biz.service.admin.CourseService;
import com.barley.training.biz.service.convert.CourseConvertMapper;
import com.barley.training.stub.biz.request.CourseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.barley.common.base.constants.Constants.LIMIT_1;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Override
    public boolean saveBy(CourseRequest request) {
        return this.saveOrUpdate(CourseConvertMapper.INSTANCE.toEntity(request));
    }

    @Override
    public boolean removeBy(long id) {
        return this.lambdaUpdate().set(Course::getIsDelete, true)
                .eq(Course::getId, id)
                .last(LIMIT_1)
                .update();
    }
}
