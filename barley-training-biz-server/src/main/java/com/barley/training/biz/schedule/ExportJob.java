package com.barley.training.biz.schedule;

import com.barley.training.biz.entity.ExportTask;
import com.barley.training.biz.service.ExportTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class ExportJob {
    private final ExportTaskService exportTaskService;

    /**
     * 导出的定时任务轮询.
     */
    @Scheduled(fixedDelay = 5000)
    public void exportTask() {
        final String osName = System.getProperty("os.name").toLowerCase(Locale.ROOT);
        if (osName.contains("nux") || osName.contains("nix")) {
            final List<ExportTask> exportTaskList = exportTaskService.getTaskList(15);
            if (exportTaskList.isEmpty()) {
                return;
            }
            for (ExportTask exportTask : exportTaskList) {
                exportTaskService.export(exportTask);
            }
        }
    }
}
