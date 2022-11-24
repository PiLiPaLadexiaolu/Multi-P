package com.sxd.apimobile.exception;

import com.sxd.apimobile.utils.ResultUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.xml.transform.Result;

@RestControllerAdvice(basePackages = "com.sxd")
public class ResponseAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    /**
     * 更改HTTP状态码
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof ResultUtil) {
            if (((ResultUtil) body).getCode().equals(ExceptionEnum.UNAUTHORIZED.getCode())) {
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
            }
            return body;
        }
        return ResultUtil.FAILURE();
    }
}
