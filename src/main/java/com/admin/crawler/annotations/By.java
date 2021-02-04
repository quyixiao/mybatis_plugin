package com.admin.crawler.annotations;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.PARAMETER,ElementType.FIELD})
public @interface By {

    String [] value() default {};

    OrderType type() default OrderType.ASC;

}
