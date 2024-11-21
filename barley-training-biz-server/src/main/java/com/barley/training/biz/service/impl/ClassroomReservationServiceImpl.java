package com.barley.training.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.training.biz.entity.ClassroomReservation;
import com.barley.training.biz.mapper.ClassroomReservationMapper;
import com.barley.training.biz.service.ClassroomReservationService;
import com.barley.training.biz.service.convert.ClassroomReservationConvertMapper;
import com.barley.training.stub.biz.request.ClassroomReservationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.barley.common.base.constants.Constants.LIMIT_1;

@Service
@RequiredArgsConstructor
public class ClassroomReservationServiceImpl extends ServiceImpl<ClassroomReservationMapper, ClassroomReservation> implements ClassroomReservationService {

    @Override
    public boolean saveBy(ClassroomReservationRequest request) {
        return this.saveOrUpdate(ClassroomReservationConvertMapper.INSTANCE.toEntity(request));
    }

    @Override
    public boolean removeBy(long id) {
        return this.lambdaUpdate().set(ClassroomReservation::getIsDelete, true)
                .eq(ClassroomReservation::getId, id)
                .last(LIMIT_1)
                .update();
    }
}
