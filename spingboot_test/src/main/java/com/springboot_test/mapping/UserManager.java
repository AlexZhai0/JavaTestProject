package com.springboot_test.mapping;

import com.springboot_test.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserManager {

    @Select("select name, age from tb_user")
    List<User> list();
}
