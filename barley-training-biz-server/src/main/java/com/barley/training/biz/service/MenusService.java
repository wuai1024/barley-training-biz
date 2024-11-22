package com.barley.training.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barley.training.biz.entity.Menus;
import com.barley.training.stub.biz.bean.MenusDTO;

import java.util.List;

public interface MenusService extends IService<Menus> {
    List<MenusDTO> getMenus();

    List<MenusDTO> getTreeMenus(boolean isPrimary, long userLongId);
}
