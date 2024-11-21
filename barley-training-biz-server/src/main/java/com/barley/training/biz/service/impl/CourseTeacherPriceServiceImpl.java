package com.barley.training.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.training.biz.entity.CourseTeacherPrice;
import com.barley.training.biz.mapper.CourseTeacherPriceMapper;
import com.barley.training.biz.service.CourseTeacherPriceService;
import com.barley.training.biz.service.convert.CourseTeacherPriceConvertMapper;
import com.barley.training.stub.biz.request.CourseTeacherPriceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.barley.common.base.constants.Constants.LIMIT_1;

@Service
@RequiredArgsConstructor
public class CourseTeacherPriceServiceImpl extends ServiceImpl<CourseTeacherPriceMapper, CourseTeacherPrice> implements CourseTeacherPriceService {

    @Override
    public boolean saveBy(CourseTeacherPriceRequest request) {
        return this.saveOrUpdate(CourseTeacherPriceConvertMapper.INSTANCE.toEntity(request));
    }

    @Override
    public boolean removeBy(long id) {
        return this.lambdaUpdate().set(CourseTeacherPrice::getIsDelete, true)
                .eq(CourseTeacherPrice::getId, id)
                .last(LIMIT_1)
                .update();
    }
}
