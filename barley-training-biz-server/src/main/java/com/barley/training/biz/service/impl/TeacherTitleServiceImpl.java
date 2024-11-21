package com.barley.training.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.training.biz.entity.TeacherTitle;
import com.barley.training.biz.mapper.TeacherTitleMapper;
import com.barley.training.biz.service.TeacherTitleService;
import com.barley.training.biz.service.convert.TeacherTitleConvertMapper;
import com.barley.training.stub.biz.request.TeacherTitleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.barley.common.base.constants.Constants.LIMIT_1;

@Service
@RequiredArgsConstructor
public class TeacherTitleServiceImpl extends ServiceImpl<TeacherTitleMapper, TeacherTitle> implements TeacherTitleService {

    @Override
    public boolean saveBy(TeacherTitleRequest request) {
        return this.saveOrUpdate(TeacherTitleConvertMapper.INSTANCE.toEntity(request));
    }

    @Override
    public boolean removeBy(long id) {
        return this.lambdaUpdate().set(TeacherTitle::getIsDelete, true)
                .eq(TeacherTitle::getId, id)
                .last(LIMIT_1)
                .update();
    }
}
