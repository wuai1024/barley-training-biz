package com.barley.training.biz.service.client;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barley.training.biz.entity.Student;
import com.barley.training.stub.biz.bean.client.ClientDTO;
import com.barley.training.stub.biz.request.AuthRequest;

public interface StudentClientService extends IService<Student> {
    ClientDTO login(AuthRequest request);

    ClientDTO loginByPhone(AuthRequest request);
}
