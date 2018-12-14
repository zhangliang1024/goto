package com.argument.annotation;

import com.argument.constant.DateFormatPattern;

import java.lang.annotation.*;

/**
 * @Auther: colin
 * @Date: 2018/12/11 17:06
 * @Description:
 * @Version: V1.0
 */
@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestDateParam {

    String value () default "";

    DateFormatPattern pattern() default DateFormatPattern.YYYY_MM_DD_HH_MM_SS;

    boolean required() default false;
}
