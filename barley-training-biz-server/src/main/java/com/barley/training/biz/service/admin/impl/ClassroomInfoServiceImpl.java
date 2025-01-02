package com.barley.training.biz.service.admin.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.training.biz.entity.ClassroomInfo;
import com.barley.training.biz.mapper.ClassroomInfoMapper;
import com.barley.training.biz.service.admin.ClassroomInfoService;
import com.barley.training.biz.service.convert.ClassroomInfoConvertMapper;
import com.barley.training.stub.biz.request.ClassroomInfoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.barley.common.base.constants.Constants.LIMIT_1;

@Service
@RequiredArgsConstructor
public class ClassroomInfoServiceImpl extends ServiceImpl<ClassroomInfoMapper, ClassroomInfo> implements ClassroomInfoService {

    @Override
    public boolean saveBy(ClassroomInfoRequest request) {
        return this.saveOrUpdate(ClassroomInfoConvertMapper.INSTANCE.toEntity(request));
    }

    @Override
    public boolean removeBy(long id) {
        return this.lambdaUpdate().set(ClassroomInfo::getIsDelete, true)
                .eq(ClassroomInfo::getId, id)
                .last(LIMIT_1)
                .update();
    }
}
