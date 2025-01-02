package com.barley.training.biz.service.admin;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barley.training.biz.entity.SysUser;
import com.barley.training.stub.biz.bean.admin.UserDTO;
import com.barley.training.stub.biz.request.AuthRequest;
import com.barley.training.stub.biz.request.SysUserRequest;

public interface SysUserService extends IService<SysUser> {
    UserDTO login(AuthRequest request);

    boolean saveBy(SysUserRequest request);

    boolean resetPassword(long id, String password);

    boolean removeBy(long id);

    boolean existByRoleId(long roleId);
}
