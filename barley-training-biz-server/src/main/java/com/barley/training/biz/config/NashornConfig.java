package com.barley.training.biz.config;

import com.barley.common.datasource.factory.NashornFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
@RequiredArgsConstructor
public class NashornConfig implements NashornFactory {
    private final ApplicationContext applicationContext;

    @Override
    public Map<String, Object> createNashorn() {
        final Map<String, Object> a = new HashMap<>();
        a.put("utils", new Utils());
//        a.put("pair", applicationContext.getBean(PairService.class));
//        a.put("queryService", applicationContext.getBean(QueryService.class));
        return a;
    }

    @Override
    public List<String> getClearKey() {
        return List.of("global", "excel", "utils", "pair", "queryService");
    }

    public static class Utils {
        /**
         * 将值类型转换 (Excel 导出).
         *
         * @param value 值.
         * @return 类型转换后的值.
         */
        public Object valueToString(Object value) {
            if (value instanceof Date a) {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(a);
            }
            if (value instanceof LocalDate a) {
                return a.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
            if (value instanceof LocalDateTime a) {
                return a.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }
            return Objects.toString(value);
        }
    }
}
