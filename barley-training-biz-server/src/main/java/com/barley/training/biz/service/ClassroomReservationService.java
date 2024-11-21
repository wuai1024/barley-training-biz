package com.barley.training.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barley.training.biz.entity.ClassroomReservation;
import com.barley.training.stub.biz.request.ClassroomReservationRequest;

public interface ClassroomReservationService extends IService<ClassroomReservation> {

    boolean saveBy(ClassroomReservationRequest request);

    boolean removeBy(long id);
}
