package com.barley.training.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.barley.training.biz.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}



