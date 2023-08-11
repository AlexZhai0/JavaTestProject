package com.springboot_test.service;


import com.springboot_test.bean.Emp;

import java.util.List;

public interface EmpService {
    //获取员工列表
    List<Emp> listEmp();
}
