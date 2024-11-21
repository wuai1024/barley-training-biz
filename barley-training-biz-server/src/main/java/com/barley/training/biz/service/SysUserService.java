package com.barley.training.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barley.training.biz.entity.SysUser;
import com.barley.training.stub.biz.request.SysUserRequest;

public interface SysUserService extends IService<SysUser> {
    boolean saveBy(SysUserRequest request);

    boolean resetPassword(long id, String password);

    boolean removeBy(long id);

    boolean existByRoleId(long roleId);
}
