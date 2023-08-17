package com.springboot_test.service;


import com.springboot_test.bean.Emp;
import com.springboot_test.bean.EmpOld;
import com.springboot_test.bean.PageBean;

import java.time.LocalDate;
import java.util.List;

//员工业务规则
public interface EmpService {
    //获取员工列表
    List<EmpOld> listEmp();

    // 分页查询
    PageBean page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);

    // 批量删除
    void delete(List<Integer> ids);

    void save(Emp emp);

    Emp getById(Integer id);

    void update(Emp emp);
}
