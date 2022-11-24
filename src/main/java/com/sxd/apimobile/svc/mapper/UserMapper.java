package com.sxd.apimobile.svc.mapper;

import com.sxd.apimobile.svc.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE user_name = #{userName} and password = #{password}")
    public List<User> queryUserByUserAndPassword(User user);
}
