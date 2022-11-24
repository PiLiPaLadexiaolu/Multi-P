package com.sxd.apimobile.api;

import com.sxd.apimobile.auth.annotatin.CheckToken;
import com.sxd.apimobile.auth.annotatin.PassToken;
import com.sxd.apimobile.svc.entity.User;
import com.sxd.apimobile.svc.service.UserService;
import com.sxd.apimobile.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
@Slf4j
@RestController
public class AuthController {



    @Autowired
    UserService userService;

    @PassToken
    @PostMapping("/login")
    public ResultUtil<?> login(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {

        Map res =  userService.login(user);
        if(res!=null) {
            return ResultUtil.SUCCESS(res);
        }
        return ResultUtil.FAILURE();
    }

    @CheckToken
    @PostMapping("/authToken")
    public ResultUtil<?> auth(HttpServletRequest request, HttpServletResponse response) {
        return ResultUtil.SUCCESS();
    }



}
