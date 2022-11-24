package com.sxd.apimobile.svc.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxd.apimobile.svc.entity.TestInfo;
import com.sxd.apimobile.svc.mapper.TestInfoMapper;
import com.sxd.apimobile.svc.service.ITestInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author axd
 * @since 2022-11-24
 */
@Service
public class TestInfoServiceImpl extends ServiceImpl<TestInfoMapper, TestInfo> implements ITestInfoService {

    @Autowired
    TestInfoMapper testInfoMapper;
    @Override
    public Page<TestInfo> queryPage(Page<TestInfo> page) {
        return page.setRecords(testInfoMapper.queryPage(page));
    }
}
