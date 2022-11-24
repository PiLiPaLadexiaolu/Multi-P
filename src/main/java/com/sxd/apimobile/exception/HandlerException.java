package com.sxd.apimobile.exception;


import com.sxd.apimobile.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class HandlerException {

    /**
     * 捕获 NoTokenException
     * @param e
     * @return
     */
    @ExceptionHandler(NoTokenException.class)
    public ResultUtil<?> handleCheckedException(NoTokenException e){
        log.error("NoTokenException异常: {}",e.getMessage());
        // 403 400 401 200 出口
        return ResultUtil.CUSTOM(ExceptionEnum.UNAUTHORIZED.getCode(),ExceptionEnum.UNAUTHORIZED.getMsg(),null);
    }


    /**
     * 捕获 Exception
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResultUtil<?> handleException(Exception e){
        e.printStackTrace();
        log.error("{},{}",e,e.getStackTrace());
        return ResultUtil.FAILURE();
    }

}
