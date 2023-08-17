package com.springboot_test.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/*员工类*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer gender;
    private String image;
    private Integer job;
    private LocalDate entrydate; //LocalDate类型对应数据表中的date类型
    private Integer deptId;
    private LocalDateTime createTime;//LocalDateTime类型对应数据表中的datetime类型
    private LocalDateTime updateTime;
}
