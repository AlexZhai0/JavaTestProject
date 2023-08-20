package com.springboot_test.service.impl;

import com.springboot_test.bean.Dept;
import com.springboot_test.bean.DeptLog;
import com.springboot_test.mapping.DeptMapper;
import com.springboot_test.mapping.EmpMapper;
import com.springboot_test.service.DeptLogService;
import com.springboot_test.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

//部门业务实现类
@Slf4j
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogService deptLogService;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    /*@Override
    public void delete(Integer id) {
        deptMapper.deleteById(id);
    }*/

    @Override
    public void add(Dept dept) {
        //补全部门数据
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        //调用持久层增加功能
        deptMapper.insert(dept);
    }

    //@Transactional(rollbackFor = Exception.class) //spring事务管理
    @Transactional
    @Override
    public void delete(Integer id) {
        try {
            deptMapper.deleteById(id); //根据ID删除部门数据

//            int i = 1/0;
            //if(true){throw new Exception("出错啦...");}

            empMapper.deleteByDeptId(id); //根据部门ID删除该部门下的员工
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作,此次解散的是"+id+"号部门");
            deptLogService.insert(deptLog);
        }
    }
}
