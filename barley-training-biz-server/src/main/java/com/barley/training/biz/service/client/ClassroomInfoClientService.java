package com.barley.training.biz.service.client;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barley.training.biz.entity.ClassroomInfo;
import com.barley.training.stub.biz.bean.client.ClassroomInfoDTO;

import java.util.List;

/**
 *
 */
public interface ClassroomInfoClientService extends IService<ClassroomInfo> {

    List<ClassroomInfoDTO> getList();

    ClassroomInfoDTO getBy(long id);
}
