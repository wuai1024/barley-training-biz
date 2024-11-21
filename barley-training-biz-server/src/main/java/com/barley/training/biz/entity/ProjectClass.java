package com.barley.training.biz.entity;

import com.barley.common.datasource.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 项目班级
 */
@Setter
@Getter
public class ProjectClass extends BaseEntity implements Serializable {

    private Long id;
    private Long projectId;
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