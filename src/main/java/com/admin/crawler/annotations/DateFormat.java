package com.admin.crawler.annotations;

import java.lang.annotation.*;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface DateFormat {
    String value() default "%Y-%m-%d %H:%i:%S";
}

