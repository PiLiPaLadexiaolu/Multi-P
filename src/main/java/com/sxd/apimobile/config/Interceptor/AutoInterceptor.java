package com.sxd.apimobile.config.Interceptor;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.sxd.apimobile.auth.annotatin.CheckToken;
import com.sxd.apimobile.auth.annotatin.PassToken;
import com.sxd.apimobile.auth.utils.JWTUtil;
import com.sxd.apimobile.auth.utils.TokenParams;
import com.sxd.apimobile.exception.NoTokenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Component 和 @Service 是一个作用 创建对象
 */
@Component
@Slf4j
public class AutoInterceptor implements HandlerInterceptor {

    @Autowired
    RedisTemplate redisTemplate;
    /**
     * 在请求到达Controller控制器之前 通过拦截器执行一段代码
     * 如果方法返回true,继续执行后续操作
     * 如果返回false，执行中断请求处理，请求不会发送到Controller
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("AutoInterceptor拦截器 在控制器执行之前执行");
        // 添加用户鉴权
        log.info("AuthenticationInterceptor-Token过滤器执行");
        // 从 http 请求头中取出 token
        String token = request.getHeader("Token");
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        // 检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(CheckToken.class)) {
            // 添加Redis判断 暂未添加
            CheckToken userLoginToken = method.getAnnotation(CheckToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    log.error("无token，请重新登录");
                    throw new NoTokenException("登录错误");
                }
                // 获取 token 中的 user id
                Boolean flag = null;
                try {
                    flag = JWTUtil.verifyToken(token, TokenParams.TOKEN_KEY);
                } catch (JWTDecodeException j) {
                    log.error("无权操作");
                    throw new NoTokenException("Token失效");
                }
                if (flag) {
                    return true;
                } else {
                    throw new NoTokenException("Token失效");
                }
            }
        }
        return true;

    }

    /**
     * 控制器之后，跳转前
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("AutoInterceptor拦截器 在控制器执行之后执行");
    }

    /**
     * 跳转之后执行
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("AutoInterceptor拦截器 最后执行");
    }
}