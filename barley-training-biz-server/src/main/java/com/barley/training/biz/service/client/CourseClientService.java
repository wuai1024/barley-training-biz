package com.barley.training.biz.service.client;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barley.training.biz.entity.Course;
import com.barley.training.stub.biz.bean.client.CourseDTO;
import com.barley.training.stub.biz.bean.client.CourseViewDTO;

import java.util.List;


public interface CourseClientService extends IService<Course> {

    List<CourseDTO> getList();

    CourseDTO getBy(long id);

    List<CourseViewDTO> getViewBy(long id);

    CourseViewDTO getLive();
}
