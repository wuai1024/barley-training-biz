package com.barley.training.biz.constant.enums;

import lombok.Getter;

/**
 * 导出任务状态.
 */
@Getter
public enum ExportTaskStatusEnum {
    /**
     * 准备就绪.
     */
    READY(0, "导出执行中"),
    /**
     * 导出执行中.
     */
    HANDLE(1, "导出执行中"),
    /**
     * 导出完成.
     */
    COMPLETED(2, "导出执行完成"),
    /**
     * 导出错误.
     */
    ERROR(9, "导出错误");

    private final int code;
    private final String description;

    ExportTaskStatusEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
