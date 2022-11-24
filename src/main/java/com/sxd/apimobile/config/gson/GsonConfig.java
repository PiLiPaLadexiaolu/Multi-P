package com.sxd.apimobile.config.gson;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 配置GSON作为Controller层反序列化工具
 * 不使用反序列化时日期失败 踩坑
 */
//@Configuration
public class GsonConfig {
 /*
  *   @Bean
  *   public HttpMessageConverters customConverters() {
  *       Collection<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
  *       GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
  *       messageConverters.add(gsonHttpMessageConverter);
  *       return new HttpMessageConverters(true, messageConverters);
  *   }
  */
}