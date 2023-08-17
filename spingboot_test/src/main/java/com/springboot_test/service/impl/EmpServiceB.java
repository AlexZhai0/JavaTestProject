package com.springboot_test.service.impl;

import com.springboot_test.bean.Emp;
import com.springboot_test.bean.EmpOld;
import com.springboot_test.bean.PageBean;
import com.springboot_test.dao.EmpDao;
import com.springboot_test.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

//@Component //将当前类交给IOC容器管理, 成为IOC容器中的bean
@Service
public class EmpServiceB implements EmpService {

    @Autowired //运行时, IOC容器会提供该类型的bean对象,并赋值给该变量 - 依赖注入
    private EmpDao empDao;

    @Override
    public List<EmpOld> listEmp() {
        //1. 调用dao, 获取数据
        List<EmpOld> empList = empDao.listEmp();

        //2. 对数据进行转换处理 - gender, job
        empList.stream().forEach(emp -> {
            //处理 gender 1: 男, 2: 女
            String gender = emp.getGender();
            if("1".equals(gender)){
                emp.setGender("男士");
            }else if("2".equals(gender)){
                emp.setGender("女士");
            }

            //处理job - 1: 讲师, 2: 班主任 , 3: 就业指导
            String job = emp.getJob();
            if("1".equals(job)){
                emp.setJob("讲师");
            }else if("2".equals(job)){
                emp.setJob("班主任");
            }else if("3".equals(job)){
                emp.setJob("就业指导");
            }
        });
        return empList;
    }

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {
        return null;
    }

    @Override
    public void delete(List<Integer> ids) {

    }

    @Override
    public void save(Emp emp) {

    }

    @Override
    public Emp getById(Integer id) {
        return null;
    }

    @Override
    public void update(Emp emp) {

    }
}
