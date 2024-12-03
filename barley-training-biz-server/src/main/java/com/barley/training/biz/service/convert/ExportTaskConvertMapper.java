package com.barley.training.biz.service.convert;

import com.barley.training.biz.entity.ExportTask;
import com.barley.training.stub.biz.bean.ExportTaskDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ExportTaskConvertMapper {
    ExportTaskConvertMapper INSTANCE = Mappers.getMapper(ExportTaskConvertMapper.class);


    List<ExportTaskDTO> toDTOList(List<ExportTask> list);
}
