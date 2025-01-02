package com.barley.training.biz.controller.admin;

import com.barley.common.base.response.ResponseData;
import com.barley.training.biz.service.admin.CourseTeacherPriceService;
import com.barley.training.stub.biz.facade.admin.CourseTeacherPriceFacade;
import com.barley.training.stub.biz.request.CourseTeacherPriceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CourseTeacherPriceFacade.URL)
@RequiredArgsConstructor
public class CourseTeacherPriceController implements CourseTeacherPriceFacade {

    private final CourseTeacherPriceService courseTeacherPriceService;


    @Override
    public ResponseData<Boolean> save(CourseTeacherPriceRequest request) {
        return ResponseData.SUCCESS(courseTeacherPriceService.saveBy(request));
    }

    @Override
    public ResponseData<Boolean> deleteById(long id) {
        return ResponseData.SUCCESS(courseTeacherPriceService.removeBy(id));
    }
}
