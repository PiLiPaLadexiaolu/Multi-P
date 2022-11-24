package com.sxd.apimobile.svc.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxd.apimobile.svc.entity.TestInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author axd
 * @since 2022-11-24
 */
@Mapper
public interface TestInfoMapper extends BaseMapper<TestInfo> {
    @Select("SELECT * FROM test_info")
    List<TestInfo> queryPage(Page<TestInfo> page);
}
