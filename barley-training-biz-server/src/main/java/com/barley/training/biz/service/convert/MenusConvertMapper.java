package com.barley.training.biz.service.convert;


import com.barley.training.biz.entity.Menus;
import com.barley.training.stub.biz.bean.MenusDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MenusConvertMapper {

    MenusConvertMapper INSTANCE = Mappers.getMapper(MenusConvertMapper.class);

    List<MenusDTO> toDTOList(List<Menus> list);
}
