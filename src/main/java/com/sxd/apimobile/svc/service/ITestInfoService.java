package com.sxd.apimobile.svc.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxd.apimobile.svc.entity.TestInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author axd
 * @since 2022-11-24
 */
public interface ITestInfoService extends IService<TestInfo> {

    Page<TestInfo> queryPage(Page<TestInfo> page);
}
