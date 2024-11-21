package com.barley.training.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.barley.training.biz.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    boolean existByRoleId(@Param("roleId") long roleId);
}
