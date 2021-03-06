package com.dep.sspanel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({ ElementType.PARAMETER, ElementType.METHOD })//目标是方法和参数
@Retention(RetentionPolicy.RUNTIME)//注解会在class中存在，运行时可通过反射获取  
@Documented//文档生成时，该注解将被包含在javadoc中，可去掉
public @interface SystemControllerLog {
	String description() default "";
}
