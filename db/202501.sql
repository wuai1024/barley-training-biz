-- 教室增加图片
ALTER TABLE barley_training.classroom_info
    ADD images varchar(100) NULL COMMENT '教室图片';
ALTER TABLE barley_training.classroom_info CHANGE images images varchar (100) NULL COMMENT '教室图片' AFTER `type`;

-- 修改老师附件名称
ALTER TABLE barley_training.teacher CHANGE images files json NULL;

-- 教师增加头像
ALTER TABLE barley_training.teacher
    ADD images varchar(100) NULL COMMENT '头像照片';
ALTER TABLE barley_training.teacher CHANGE images images varchar (100) NULL COMMENT '头像照片' AFTER name;

-- 培训班增加图片
ALTER TABLE barley_training.project_class
    ADD images varchar(100) NULL COMMENT '培训班 图片';
ALTER TABLE barley_training.project_class CHANGE images images varchar (100) NULL COMMENT '培训班 图片' AFTER class_name;

-- 课程增加课件、名称、视频ID
ALTER TABLE barley_training.course
    ADD files varchar(100) NULL COMMENT '课件';
ALTER TABLE barley_training.course CHANGE files files varchar (100) NULL COMMENT '课件' AFTER hours;
ALTER TABLE barley_training.course
    ADD course_name varchar(100) NULL COMMENT '课程名称';
ALTER TABLE barley_training.course CHANGE course_name course_name varchar (100) NULL COMMENT '课程名称' AFTER classroom_id;
ALTER TABLE barley_training.course
    ADD live_id INT NULL COMMENT '视频ID';
ALTER TABLE barley_training.course CHANGE live_id live_id INT NULL COMMENT '视频ID' AFTER course_name;


-- 删除hours字段
ALTER TABLE barley_training.project DROP COLUMN hours;

-- 设备增加第三方ID
ALTER TABLE barley_training.device_info
    ADD third_id INT NULL COMMENT '第三方ID';
ALTER TABLE barley_training.device_info CHANGE third_id third_id INT NULL COMMENT '第三方ID' AFTER device_name;
