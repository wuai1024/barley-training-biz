package com.barley.training.biz.service.admin;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barley.training.biz.entity.TeacherTitle;
import com.barley.training.stub.biz.request.TeacherTitleRequest;

public interface TeacherTitleService extends IService<TeacherTitle> {

    boolean saveBy(TeacherTitleRequest request);

    boolean removeBy(long id);
}
