package com.dai7.spring;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * String到Date类型转换
 */
public class StringToDateConverter implements Converter<String, Date> {

    private final String dateFormatPattern = "yyyy-MM-dd";

    private final String dateTimeFormatPattern = "yyyy-MM-dd HH:mm:ss";

    @Override
    public Date convert(String source) {

        if (!StringUtils.hasLength(source)) {
            //如果source为空 返回null
            return null;
        }

        DateFormat df;

        try {
            df = new SimpleDateFormat(dateTimeFormatPattern);
            //转换成功
            return df.parse(source);
        } catch (ParseException e) {
            try {
                df = new SimpleDateFormat(dateFormatPattern);
                //转换成功
                return df.parse(source);
            } catch (ParseException pe) {
                //转化失败
                throw new IllegalArgumentException(String.format("类型转换失败，格式是[%s]", source));
            }
        }
    }
}