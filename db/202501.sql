-- 教室增加图片
ALTER TABLE barley_training.classroom_info ADD images varchar(100) NULL COMMENT '教室图片';
ALTER TABLE barley_training.classroom_info CHANGE images images varchar(100) NULL COMMENT '教室图片' AFTER `type`;

-- 修改老师附件名称
ALTER TABLE barley_training.teacher CHANGE images files json NULL;

-- 教师增加头像
ALTER TABLE barley_training.teacher ADD images varchar(100) NULL COMMENT '头像照片';
ALTER TABLE barley_training.teacher CHANGE images images varchar(100) NULL COMMENT '头像照片' AFTER name;

-- 培训班增加图片
ALTER TABLE barley_training.project_class ADD images varchar(100) NULL COMMENT '培训班 图片';
ALTER TABLE barley_training.project_class CHANGE images images varchar(100) NULL COMMENT '培训班 图片' AFTER class_name;

-- 课程增加课件
ALTER TABLE barley_training.course ADD files varchar(100) NULL COMMENT '课件';
ALTER TABLE barley_training.course CHANGE files files varchar(100) NULL COMMENT '课件' AFTER hours;

-- 删除hours字段
ALTER TABLE barley_training.project DROP COLUMN hours;