package com.barley.training.biz.controller.admin;

import com.barley.common.base.response.ResponseData;
import com.barley.training.biz.service.admin.ClassroomReservationService;
import com.barley.training.stub.biz.facade.admin.ClassroomReservationFacade;
import com.barley.training.stub.biz.request.ClassroomReservationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ClassroomReservationFacade.URL)
@RequiredArgsConstructor
public class ClassroomReservationController implements ClassroomReservationFacade {

    private final ClassroomReservationService classroomReservationService;


    @Override
    public ResponseData<Boolean> save(ClassroomReservationRequest request) {
        return ResponseData.SUCCESS(classroomReservationService.saveBy(request));
    }

    @Override
    public ResponseData<Boolean> deleteById(long id) {
        return ResponseData.SUCCESS(classroomReservationService.removeBy(id));
    }
}
