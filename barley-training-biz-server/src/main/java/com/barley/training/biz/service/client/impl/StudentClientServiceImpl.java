package com.barley.training.biz.service.client.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.common.auth.session.SessionService;
import com.barley.common.base.LoginUser;
import com.barley.training.biz.constant.UscResponseCode;
import com.barley.training.biz.entity.Student;
import com.barley.training.biz.mapper.StudentMapper;
import com.barley.training.biz.service.client.StudentClientService;
import com.barley.training.stub.biz.bean.client.ClientDTO;
import com.barley.training.stub.biz.request.AuthRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.barley.common.base.constants.Constants.LIMIT_1;

@Service
@RequiredArgsConstructor
public class StudentClientServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentClientService {
    private final SessionService sessionService;

    @Override
    public ClientDTO login(AuthRequest request) {
        final Student student = this.lambdaQuery()
                .eq(Student::getPhone, request.getPhone())
                .eq(Student::getCode, request.getCode())
                .last(LIMIT_1)
                .one();
        if (Objects.isNull(student)) {
            throw UscResponseCode.ERROR.newException("当前用户不存在！");
        }
        return login(student);
    }

    @SneakyThrows
    @Override
    public ClientDTO loginByPhone(AuthRequest request) {
        final Student student = this.lambdaQuery()
                .eq(Student::getPhone, request.getPhone())
                .eq(Student::getCode, request.getCode())
                .last(LIMIT_1)
                .one();
        if (Objects.isNull(student)) {
            throw UscResponseCode.ERROR.newException("当前用户不存在！");
        }
        return login(student);
    }

    private ClientDTO login(Student student) {
        final String userId = Objects.toString(student.getId());
        final String token = "STUDENT." + UUID.randomUUID().toString().replaceAll("-", "");
        final LoginUser loginUser = new LoginUser();
        loginUser.setId(userId);
        loginUser.setNickName(student.getName());
        loginUser.setMobile(student.getPhone());
        final ClientDTO client = new ClientDTO();
        client.setId(userId);
        client.setAccessToken(token);

        // 保存到会话
        sessionService.saveToken(token, userId, 3, TimeUnit.DAYS);
        sessionService.saveUserSession(userId, loginUser, 3, TimeUnit.DAYS);
        return client;
    }
}
