package com.sxd.apimobile.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "demo",url = "http://localhost:8080/")
public interface TestFeign {
    @GetMapping("test1") //被调用接口的请求类型
    String test1();

}