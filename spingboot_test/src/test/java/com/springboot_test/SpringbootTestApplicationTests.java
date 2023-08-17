package com.springboot_test;

import com.springboot_test.bean.Emp;
import com.springboot_test.bean.User;
import com.springboot_test.mapping.EmpMapper;
import com.springboot_test.mapping.UserManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringbootTestApplicationTests {

    @Autowired
    private UserManager userManager;

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testUserList() {
        List<User> list = userManager.list();
        System.out.println("用户信息：" + list);
    }

    @Test
    public void testEmp() {
        /*//创建员工对象
        Emp emp = new Emp();
        emp.setUsername("tom");
        emp.setName("汤姆");
        emp.setImage("1.jpg");
        emp.setGender(1);
        emp.setJob(1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);
        empMapper.insert(emp);
        System.out.println("插入员工信息成功：ID：" + emp.getId());*/

        /*//要修改的员工信息
        Emp emp = new Emp();
        emp.setId(19);
        emp.setUsername("songdaxia");
        emp.setPassword(null);
        emp.setName("老宋");
        emp.setImage("2.jpg");
        emp.setGender(1);
        emp.setJob(2);
        emp.setEntrydate(LocalDate.of(2012,1,1));
        emp.setCreateTime(null);
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(2);
        //调用方法，修改员工数据
        empMapper.update(emp);*/

        /*Emp emp = empMapper.getById(17);
        System.out.println("员工信息：" + emp);*/

        /*empMapper.delete(18);
        System.out.println("删除员工信息成功");*/

        /*List<Emp> empList = empMapper.list("张", 1, LocalDate.of(2010, 1, 1), LocalDate.of(2020, 1, 1));
        System.out.println(empList);*/

        /*// List<Emp> empList = empMapper.list2("张", 1, LocalDate.of(2010, 1, 1), LocalDate.of(2020, 1, 1));
        // List<Emp> empList = empMapper.list2("张", null, null, null);
        // List<Emp> empList = empMapper.list2("张", 1, null, null);
        // List<Emp> empList = empMapper.list2(null, 1, null, null);*/
        List<Emp> empList = empMapper.list2(null, null, null, null);
        System.out.println(empList);

        /*//要修改的员工信息
        Emp emp = new Emp();
        emp.setId(19);
        emp.setUsername("Tom222");
        //emp.setName("汤姆111");
        //emp.setUpdateTime(LocalDateTime.now());
        //调用方法，修改员工数据
        empMapper.update2(emp);*/

//        List<Integer> ids = Arrays.asList(17, 19);
//        empMapper.deleteByIds(ids);

    }

}
