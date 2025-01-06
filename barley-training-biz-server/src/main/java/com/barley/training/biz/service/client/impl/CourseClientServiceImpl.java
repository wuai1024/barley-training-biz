package com.barley.training.biz.service.client.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barley.training.biz.channel.ItcApis;
import com.barley.training.biz.entity.*;
import com.barley.training.biz.mapper.CourseMapper;
import com.barley.training.biz.service.admin.ProjectService;
import com.barley.training.biz.service.client.*;
import com.barley.training.biz.service.convert.CourseConvertMapper;
import com.barley.training.stub.biz.bean.client.CourseDTO;
import com.barley.training.stub.biz.bean.client.CourseViewDTO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseClientServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseClientService {

    private final ProjectClassClientService projectClassClientService;
    private final TeacherClientService teacherClientService;
    private final ClassroomInfoClientService classroomInfoClientService;
    private final ProjectService projectService;
    private final ItcApis itcApis;

    @Override
    public List<CourseDTO> getList() {
        List<Course> courses = this.list();
        if (CollectionUtils.isEmpty(courses)) {
            return Collections.emptyList();
        }

        List<Long> classroomIds = courses.stream().map(Course::getClassroomId).distinct().toList();
        List<Long> classIds = courses.stream().map(Course::getClassId).distinct().toList();
        List<Long> teacherIds = courses.stream().map(Course::getTeacherId).distinct().toList();
        List<Long> projectIds = courses.stream().map(Course::getProjectId).distinct().toList();

        List<Project> projects = projectService.lambdaQuery().in(Project::getId, projectIds).list();
        List<ProjectClass> projectClasses = projectClassClientService.lambdaQuery().in(ProjectClass::getId, classIds).list();
        List<Teacher> teachers = teacherClientService.lambdaQuery().in(Teacher::getId, teacherIds).list();
        List<ClassroomInfo> classroomInfos = classroomInfoClientService.lambdaQuery().in(ClassroomInfo::getId, classroomIds).list();

        Map<Long, Project> pro = Optional.ofNullable(projects).orElseGet(List::of).stream().collect(Collectors.toMap(Project::getId, project -> project, (p, n) -> p));
        Map<Long, ProjectClass> proClass = Optional.ofNullable(projectClasses).orElseGet(List::of).stream().collect(Collectors.toMap(ProjectClass::getId, projectClass -> projectClass, (p, n) -> p));
        Map<Long, Teacher> proTeacher = Optional.ofNullable(teachers).orElseGet(List::of).stream().collect(Collectors.toMap(Teacher::getId, teacher -> teacher, (p, n) -> p));
        Map<Long, ClassroomInfo> proClassroom = Optional.ofNullable(classroomInfos).orElseGet(List::of).stream().collect(Collectors.toMap(ClassroomInfo::getId, classroom -> classroom, (p, n) -> p));

        return courses.stream().map(CourseConvertMapper.INSTANCE::toDTO).peek(courseDTO -> {
            courseDTO.setProjectName(pro.get(courseDTO.getProjectId()).getProjectName());
            courseDTO.setClassName(proClass.get(courseDTO.getClassId()).getClassName());
            courseDTO.setTeacherName(proTeacher.get(courseDTO.getTeacherId()).getName());
            courseDTO.setClassroomName(proClassroom.get(courseDTO.getClassroomId()).getName());
        }).toList();
    }

    @Override
    public CourseDTO getBy(long id) {
        return CourseConvertMapper.INSTANCE.toDTO(this.getById(id));
    }

    @Override
    public List<CourseViewDTO> getViewBy(long id) {
        return null;
    }

    @Override
    public CourseViewDTO getLive() {
        return null;
    }
}
