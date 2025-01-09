package com.barley.training.biz.service.admin.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.training.biz.entity.Menus;
import com.barley.training.biz.mapper.MenusMapper;
import com.barley.training.biz.service.admin.MenusService;
import com.barley.training.biz.service.convert.MenusConvertMapper;
import com.barley.training.stub.biz.bean.admin.MenusDTO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenusServiceImpl extends ServiceImpl<MenusMapper, Menus> implements MenusService {
    @Override
    public List<MenusDTO> getMenus() {
        return MenusConvertMapper.INSTANCE.toDTOList(
                this.lambdaQuery().orderByAsc(Menus::getSort).list()
        );
    }

    @Override
    public List<MenusDTO> getTreeMenus(boolean isPrimary, long userLongId) {
        final List<MenusDTO> menus = this.getMenus();
        final Map<String, List<MenusDTO>> groupMap = menus.stream().collect(Collectors.groupingBy(MenusDTO::getParentCode));
        for (MenusDTO item : menus) {
            item.setChildren(groupMap.get(item.getCode()));
        }
        return groupMap.get("").stream()
                .filter(it -> StringUtils.isNotBlank(it.getPath()) || CollectionUtils.isNotEmpty(it.getChildren()))
                .toList();
    }
}
