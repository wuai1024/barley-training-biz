package com.barley.training.biz.service.client.impl;

import com.barley.training.biz.entity.ClassroomInfo;
import com.barley.training.biz.service.client.*;
import com.barley.training.stub.biz.bean.client.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InspectClientServiceImpl implements InspectClientService {

    private final DeviceInfoClientService deviceInfoClientService;
    private final ClassroomInfoClientService classroomInfoClientService;

    @Override
    public List<InspectDTO> list() {
        List<ClassroomInfo> classroomInfos = classroomInfoClientService.list();
        if (classroomInfos.isEmpty()) {
            return List.of();
        }

        Map<Long, String> deviceClassInfo = classroomInfos.stream()
                .filter(classroom -> classroom.getDevice() != null) // 过滤没有设备信息的教室
                .flatMap(classroom -> classroom.getDevice().stream()
                        .map(device -> Map.entry(device, classroom.getName()))) // 创建设备ID和教室名称的映射
                .collect(Collectors.toMap(
                        Map.Entry::getKey, // 设备ID作为键
                        Map.Entry::getValue, // 教室名称作为值
                        (existing, replacement) -> existing // 如果出现重复键，保留现有值
                ));

        List<Long> deviceIds = classroomInfos.stream()
                .filter(classroom -> classroom.getDevice() != null)
                .flatMap(classroom -> classroom.getDevice().stream())
                .distinct()
                .toList();

        if (deviceIds.isEmpty()) {
            return List.of();
        }
        List<DeviceInfoDTO> deviceInfoDTOS = deviceInfoClientService.getListById(deviceIds);
        if (deviceInfoDTOS.isEmpty()) {
            return List.of();
        }

        return deviceInfoDTOS.stream()
                .filter(deviceInfoDTO -> deviceInfoDTO.getDeviceType().equals("S"))
                .map(deviceInfoDTO -> {
                    InspectDTO inspectDTO = new InspectDTO();
                    inspectDTO.setDeviceName(deviceInfoDTO.getDeviceName());
                    inspectDTO.setClassroomName(deviceClassInfo.get(deviceInfoDTO.getId()));
                    inspectDTO.setType(deviceInfoDTO.getDeviceType());
                    inspectDTO.setVideoUrl("www.baidu.com");
                    return inspectDTO;
                }).toList();
    }
}
