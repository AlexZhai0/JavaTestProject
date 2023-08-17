package com.springboot_test.dao;


import com.springboot_test.bean.EmpOld;

import java.util.List;

public interface EmpDao {
    //获取员工列表数据
    List<EmpOld> listEmp();
}
