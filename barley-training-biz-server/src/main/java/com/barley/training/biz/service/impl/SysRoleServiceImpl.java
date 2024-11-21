package com.barley.training.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.training.biz.constant.UscResponseCode;
import com.barley.training.biz.entity.SysRole;
import com.barley.training.biz.mapper.SysRoleMapper;
import com.barley.training.biz.service.SysRoleService;
import com.barley.training.biz.service.SysUserService;
import com.barley.training.biz.service.convert.SysRoleConvertMapper;
import com.barley.training.stub.biz.request.SysRoleRequest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    private final SysUserService sysUserService;

    @Override
    public SysRole getById(Serializable id) {
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
    public boolean saveBy(SysRoleRequest request) {
        final SysRole sysRole = this.getById(request.getId());
        final SysRole entity = SysRoleConvertMapper.INSTANCE.toEntity(request);
        if (Objects.isNull(sysRole)) {
            entity.setId(null);
        } else {
            entity.setId(sysRole.getId());
        }
        return this.saveOrUpdate(entity);
    }

    @Override
    public boolean removeBy(long id) {
        if (sysUserService.existByRoleId(id)) {
            throw UscResponseCode.ERROR.newException("角色已绑定用户");
        }
        return this.removeById(id);
    }
}
