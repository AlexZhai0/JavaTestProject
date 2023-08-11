package com.springboot_test.dao.impl;


import com.springboot_test.bean.Emp;
import com.springboot_test.dao.EmpDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository//("daoA")
//@Component //将当前对象交给IOC容器管理,成为IOC容器的bean
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        // 获取数据
        List<Emp> empList = new ArrayList<>();
        empList.add(new Emp("员工名字", 20, "./image.png", "1", "1"));
        return empList;
    }
}
