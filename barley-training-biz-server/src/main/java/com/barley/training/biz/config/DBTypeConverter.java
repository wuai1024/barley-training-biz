package com.barley.training.biz.config;

import com.barley.common.datasource.TypeConverter;
import com.barley.training.biz.entity.convert.*;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DBTypeConverter implements TypeConverter {
    @Override
    public List<Converter<?, ?>> getConverter() {
        return null;
    }

    @Override
    public List<Class<?>> getMyBatisListConverter() {
        return Arrays.asList(
                MapConvert.class,
                MapsConvert.class,
                ArrayLongConvert.class,
                ArrayStringConvert.class
        );
    }
}
