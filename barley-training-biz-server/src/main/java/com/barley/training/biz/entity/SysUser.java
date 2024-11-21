package com.barley.training.biz.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.barley.common.datasource.BaseEntity;
import com.barley.training.biz.entity.ext.ArrayStringExt;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SysUser extends BaseEntity {
    private Long id;
    private String name;
    private String phone;
    private String account;
    private String password;
    private ArrayStringExt roles;
    @TableField(value = "`primary`")
    private Boolean primary;
}
