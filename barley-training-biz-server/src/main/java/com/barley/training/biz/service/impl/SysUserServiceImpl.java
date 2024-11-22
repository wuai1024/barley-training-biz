package com.barley.training.biz.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.common.auth.session.SessionService;
import com.barley.common.base.LoginUser;
import com.barley.training.biz.constant.UscResponseCode;
import com.barley.training.biz.entity.SysUser;
import com.barley.training.biz.entity.ext.ArrayStringExt;
import com.barley.training.biz.mapper.SysUserMapper;
import com.barley.training.biz.service.SysUserService;
import com.barley.training.biz.service.convert.SysUserConvertMapper;
import com.barley.training.stub.biz.bean.UserDTO;
import com.barley.training.stub.biz.request.AuthRequest;
import com.barley.training.stub.biz.request.SysUserRequest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.barley.common.base.constants.Constants.LIMIT_1;

@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    private final SessionService sessionService;

    @Override
    public SysUser getById(Serializable id) {
        if (Objects.isNull(id)) {
            return null;
        }
        if (id instanceof String value) {
            if (StringUtils.isBlank(value)) {
                return null;
            }
        }
        return super.getById(id);
    }


    @Override
    public UserDTO login(AuthRequest request) {
        final SysUser sysUser = this.lambdaQuery().eq(SysUser::getAccount, request.getAccount())
                .eq(SysUser::getPassword, DigestUtils.md5Hex(request.getPassword()))
                .last(LIMIT_1)
                .one();
        if (Objects.isNull(sysUser)) {
            throw UscResponseCode.ERROR.newException("账号或者密码错误！");
        }
        final String userId = sysUser.getUserStringId();
        final String token = UUID.randomUUID().toString().replaceAll("-", "");
        final LoginUser loginUser = new LoginUser();
        loginUser.setId(userId);
        loginUser.setCompanyName("默认企业");
        loginUser.setAvatar("/avatar.png");
        final UserDTO user = new UserDTO();
        user.setId(userId);
        user.setAccessToken(token);

        // 保存到会话
        sessionService.saveToken(token, userId, 3, TimeUnit.DAYS);
        sessionService.saveUserSession(userId, loginUser, 3, TimeUnit.DAYS);
        return user;
    }

    @Override
    public boolean saveBy(SysUserRequest request) {
        final SysUser sysUser = this.getById(request.getId());
        final SysUser entity = SysUserConvertMapper.INSTANCE.toEntity(request);
        if (request.getPrimary()) {
            entity.setRoles(new ArrayStringExt());
        }
        if (Objects.isNull(sysUser)) {
            entity.setId(null);
            entity.setAccount(entity.getPhone());
            entity.setPassword(DigestUtils.md5Hex("admin123"));
        } else {
            entity.setId(sysUser.getId());
        }
        if (CollectionUtils.isEmpty(entity.getRoles())) {
            entity.setRoles(new ArrayStringExt());
        }
        return this.saveOrUpdate(entity);
    }

    @Override
    public boolean resetPassword(long id, String password) {
        return this.lambdaUpdate().eq(SysUser::getId, id)
                .set(SysUser::getPassword, DigestUtils.md5Hex(password))
                .last(LIMIT_1)
                .update();
    }

    @Override
    public boolean removeBy(long id) {
        return this.lambdaUpdate()
                .eq(SysUser::getId, id)
                .last(LIMIT_1)
                .remove();
    }

    @Override
    public boolean existByRoleId(long roleId) {
        return this.baseMapper.existByRoleId(roleId);
    }
}