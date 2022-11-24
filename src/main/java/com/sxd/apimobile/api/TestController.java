package com.sxd.apimobile.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxd.apimobile.rpc.TestFeign;
import com.sxd.apimobile.svc.entity.TestInfo;
import com.sxd.apimobile.svc.entity.User;
import com.sxd.apimobile.svc.service.ITestInfoService;
import com.sxd.apimobile.svc.service.impl.TestInfoServiceImpl;
import com.sxd.apimobile.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
@Slf4j
@RestController
public class TestController {


    @Autowired
    TestFeign feignController;

    @Autowired
    ITestInfoService testInfoService;

    @RequestMapping("/pageTest1")
    public ResultUtil<?> test3(User user,
                               @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
                               @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
                               HttpServletRequest req) {
        Page<TestInfo> pageList = new Page<TestInfo>(pageNo,pageSize);
        pageList = testInfoService.queryPage(pageList);
        log.info("查询当前页："+pageList.getCurrent());
        log.info("查询当前页数量："+pageList.getSize());
        log.info("查询结果数量："+pageList.getRecords().size());
        log.info("数据总数："+pageList.getTotal());
        return ResultUtil.SUCCESS(pageList);
    }





}
