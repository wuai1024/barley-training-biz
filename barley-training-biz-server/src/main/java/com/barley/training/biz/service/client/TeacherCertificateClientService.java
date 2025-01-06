package com.barley.training.biz.service.client;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barley.training.biz.entity.TeacherCertificate;
import com.barley.training.stub.biz.bean.client.TeacherCertificateDTO;

import java.util.List;


public interface TeacherCertificateClientService extends IService<TeacherCertificate> {

    List<TeacherCertificateDTO> getListById(long id);

}
