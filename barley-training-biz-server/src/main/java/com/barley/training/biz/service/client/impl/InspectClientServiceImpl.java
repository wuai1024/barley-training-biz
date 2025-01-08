package com.barley.training.biz.service.client.impl;

import com.barley.training.biz.channel.ItcApis;
import com.barley.training.biz.channel.response.InspectResponse;
import com.barley.training.biz.entity.ClassroomInfo;
import com.barley.training.biz.entity.DeviceInfo;
import com.barley.training.biz.service.client.*;
import com.barley.training.stub.biz.bean.client.InspectDTO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InspectClientServiceImpl implements InspectClientService {

    private final DeviceInfoClientService deviceInfoClientService;
    private final ClassroomInfoClientService classroomInfoClientService;
    private final ItcApis itcApis;

    @SneakyThrows
    @Override
    public List<InspectDTO> list() {
        List<ClassroomInfo> classroomInfos = classroomInfoClientService.list();
        if (classroomInfos.isEmpty()) {
            return List.of();
        }

        List<Long> deviceIds = classroomInfos.stream()
                .filter(classroom -> classroom.getDevice() != null)
                .flatMap(classroom -> classroom.getDevice().stream())
                .distinct()
                .toList();

        if (deviceIds.isEmpty()) {
            return List.of();
        }

        List<DeviceInfo> deviceInfos = deviceInfoClientService.lambdaQuery()
                .in(DeviceInfo::getId, deviceIds)
                .eq(DeviceInfo::getDeviceType, "S").list();
        if (deviceInfos.isEmpty()) {
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

        InspectResponse response = itcApis.inspect();
        Map<String, String> inspectMap = Optional.ofNullable(response.getData()).orElseGet(List::of).stream()
                .collect(Collectors.toMap(InspectResponse.DeviceData::getIp, InspectResponse.DeviceData::getM3u8Url, (p, n) -> p));
        if (inspectMap.isEmpty()) {
            return List.of();
        }
        return deviceInfos.stream()
                .map(deviceInfo -> {
                    InspectDTO inspectDTO = new InspectDTO();
                    inspectDTO.setDeviceName(deviceInfo.getDeviceName());
                    inspectDTO.setClassroomName(deviceClassInfo.get(deviceInfo.getId()));
                    inspectDTO.setType(deviceInfo.getDeviceType());
                    inspectDTO.setVideoUrl(inspectMap.get(deviceInfo.getDeviceIp()));
                    return inspectDTO;
                }).toList();
    }
}
