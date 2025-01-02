package com.barley.training.biz.service.admin.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.training.biz.entity.CourseSupervision;
import com.barley.training.biz.mapper.CourseSupervisionMapper;
import com.barley.training.biz.service.admin.CourseSupervisionService;
import com.barley.training.biz.service.convert.CourseSupervisionConvertMapper;
import com.barley.training.stub.biz.request.CourseSupervisionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.barley.common.base.constants.Constants.LIMIT_1;

@Service
@RequiredArgsConstructor
public class CourseSupervisionServiceImpl extends ServiceImpl<CourseSupervisionMapper, CourseSupervision> implements CourseSupervisionService {

    @Override
    public boolean saveBy(CourseSupervisionRequest request) {
        return this.saveOrUpdate(CourseSupervisionConvertMapper.INSTANCE.toEntity(request));
    }

    @Override
    public boolean removeBy(long id) {
        return this.lambdaUpdate().set(CourseSupervision::getIsDelete, true)
                .eq(CourseSupervision::getId, id)
                .last(LIMIT_1)
                .update();
    }
}
