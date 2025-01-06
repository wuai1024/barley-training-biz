package com.barley.training.biz.service.client.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.training.biz.entity.ClassroomInfo;
import com.barley.training.biz.mapper.ClassroomInfoMapper;
import com.barley.training.biz.service.client.ClassroomInfoClientService;
import com.barley.training.biz.service.client.DeviceInfoClientService;
import com.barley.training.biz.service.convert.ClassroomInfoConvertMapper;
import com.barley.training.stub.biz.bean.client.ClassroomInfoDTO;
import com.barley.training.stub.biz.bean.client.DeviceInfoDTO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassroomInfoClientServiceImpl extends ServiceImpl<ClassroomInfoMapper, ClassroomInfo> implements ClassroomInfoClientService {

    private final DeviceInfoClientService deviceInfoClientService;

    @Override
    public List<ClassroomInfoDTO> getList() {
        List<ClassroomInfo> classroomInfos = this.list();
        if (CollectionUtils.isEmpty(classroomInfos)) {
            return List.of();
        }
        return ClassroomInfoConvertMapper.INSTANCE.toDTOList(classroomInfos);
    }

    @Override
    public ClassroomInfoDTO getBy(long id) {
        ClassroomInfo classroomInfo = this.getById(id);
        List<DeviceInfoDTO> deviceInfoDTOS = deviceInfoClientService.getListById(classroomInfo.getDevice().stream().toList());
        ClassroomInfoDTO classroomInfoDTO = ClassroomInfoConvertMapper.INSTANCE.toDTO(classroomInfo);
        classroomInfoDTO.setDeviceInfoDTOS(deviceInfoDTOS);
        return classroomInfoDTO;
    }
}
