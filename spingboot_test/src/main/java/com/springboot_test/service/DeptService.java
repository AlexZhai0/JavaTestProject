package com.springboot_test.service;

import com.springboot_test.bean.Dept;

import java.util.List;

//部门业务规则
public interface DeptService {

    List<Dept> list();

    void delete(Integer id);

    void add(Dept dept);
}
