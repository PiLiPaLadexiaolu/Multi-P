package com.sxd.apimobile.config.log;

import com.sxd.apimobile.utils.GsonProduction;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LogAop {


    @Pointcut(value = "execution( * com.sxd.apimobile.api..*(..))")
    public void logPointCut() {}

    @Before(value = "logPointCut()")
    public void methodBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //打印请求内容
        log.info("===============请求入参-Start===============");
        log.info("请求地址:" + request.getRequestURL().toString());
        log.info("请求方式:" + request.getMethod());
        log.info("请求执行类方法 : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        log.info("请求方法参数:" + Arrays.toString(joinPoint.getArgs()));
        log.info("===============请求入参-End===============");
    }

    //在方法执行完结后打印返回内容
    @AfterReturning(returning = "o", pointcut = "logPointCut()")
    public void methodAfterReturning(Object o) {
        log.info("===============请求出参-Start===============");
        log.info("Response-Info:" + GsonProduction.GsonBuild().toJson(o));
        log.info("===============请求出参-End===============");
    }

    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object ob = pjp.proceed();// ob 为方法的返回值
        log.info("本次执行耗时 :[" + (System.currentTimeMillis() - startTime)+"]毫秒");
        return ob;
    }

}