package com.sxd.apimobile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ServletComponentScan(basePackages = {"com.sxd.apimobile"})
@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
@EnableWebMvc
public class ApiMobileApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiMobileApplication.class, args);
	}

}
