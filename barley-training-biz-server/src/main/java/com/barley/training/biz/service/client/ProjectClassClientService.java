package com.barley.training.biz.service.client;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barley.training.biz.entity.ProjectClass;
import com.barley.training.stub.biz.bean.client.ProjectClassDTO;

import java.util.List;


public interface ProjectClassClientService extends IService<ProjectClass> {

    List<ProjectClassDTO> getList();

    ProjectClassDTO getBy(long id);
}
