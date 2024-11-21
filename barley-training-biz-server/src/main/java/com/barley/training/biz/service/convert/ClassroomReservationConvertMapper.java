package com.barley.training.biz.service.convert;

import com.barley.training.biz.entity.ClassroomReservation;
import com.barley.training.stub.biz.request.ClassroomReservationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClassroomReservationConvertMapper {

    ClassroomReservationConvertMapper INSTANCE = Mappers.getMapper(ClassroomReservationConvertMapper.class);

    ClassroomReservation toEntity(ClassroomReservationRequest request);
}
