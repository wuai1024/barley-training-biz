package com.barley.training.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barley.training.biz.entity.SysRole;
import com.barley.training.stub.biz.request.SysRoleRequest;

public interface SysRoleService extends IService<SysRole> {
    boolean saveBy(SysRoleRequest request);

    boolean removeBy(long id);
}
