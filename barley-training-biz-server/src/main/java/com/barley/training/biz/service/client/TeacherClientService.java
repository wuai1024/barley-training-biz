package com.barley.training.biz.service.client;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barley.training.biz.entity.Teacher;
import com.barley.training.stub.biz.bean.client.TeacherDTO;

import java.util.List;

/**
 * Ø
 */
public interface TeacherClientService extends IService<Teacher> {

    List<TeacherDTO> getList();

    TeacherDTO getBy(long id);
}
