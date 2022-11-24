package com.sxd.apimobile.auth.annotatin;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//文档生成时，该注解将被包含在javadoc中，可去掉
@Documented 
//目标是方法
@Target(ElementType.METHOD) 
//注解会在class中存在，运行时可通过反射获取  
@Retention(RetentionPolicy.RUNTIME) 
@Inherited
public @interface PassToken {
	boolean required() default true;
}
