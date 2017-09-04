package com.dai7.spring;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * String到BigDecimal类型转换
 */
public class StringToBigdecimalConverter implements Converter<String, BigDecimal> {

    @Override
    public BigDecimal convert(String source) {

        if (!StringUtils.hasLength(source)) {
            return null;
        }

        String trimedSource = source.replace(",", "");

        return new BigDecimal(trimedSource);
    }
}
