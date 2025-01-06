package com.barley.training.stub.biz.bean.client;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 项目班级
 */
@Setter
@Getter
public class ProjectClassDTO {

    private Long id;
    private Long projectId;
    private String projectName;
    private List<String> images;
    private String className;
    private String classHeader;
    private String classHeaderPhone;
    private String classLeader;
    private String classLeaderPhone;
    private String studyCommittee;
    private String studyCommitteePhone;
    private String publicityCommittee;
    private String publicityCommitteePhone;
    private String disciplineCommittee;
    private String disciplineCommitteePhone;
    private String lifeCommittee;
    private String lifeCommitteePhone;
    private String temporarySecretary;
    private String temporarySecretaryPhone;

}