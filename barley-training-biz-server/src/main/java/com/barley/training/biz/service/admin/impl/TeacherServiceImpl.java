package com.barley.training.biz.service.admin.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.training.biz.entity.Teacher;
import com.barley.training.biz.mapper.TeacherMapper;
import com.barley.training.biz.service.admin.TeacherService;
import com.barley.training.biz.service.convert.TeacherConvertMapper;
import com.barley.training.stub.biz.request.TeacherRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.barley.common.base.constants.Constants.LIMIT_1;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Override
    public boolean saveBy(TeacherRequest request) {
        return this.saveOrUpdate(TeacherConvertMapper.INSTANCE.toEntity(request));
    }

    @Override
    public boolean removeBy(long id) {
        return this.lambdaUpdate().set(Teacher::getIsDelete, true)
                .eq(Teacher::getId, id)
                .last(LIMIT_1)
                .update();
    }
}
