package com.springboot_test.mapping;

import com.springboot_test.bean.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    /**
     * 删除某个员工
     */
    @Delete("delete from emp where id = #{id}")
    void delete(Integer id);

    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id") //会自动将生成的主键值，赋值给emp对象的id属性
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, " +
            "#{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);

    @Update("update emp set username=#{username}, name=#{name}, gender=#{gender}, " +
            "image=#{image}, job=#{job}, entrydate=#{entrydate}, dept_id=#{deptId}, " +
            "update_time=#{updateTime} where id=#{id}")
    void update(Emp emp);

    // concat方法拼接，防止注入风险
    @Select("select * from emp " +
            "where name like concat('%',#{name},'%') " +
            "and gender = #{gender} " +
            "and entrydate between #{begin} and #{end} " +
            "order by update_time desc")
    // List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);
    List<Emp> list(@Param("name") String name, @Param("gender") Integer gender, @Param("begin") LocalDate begin, @Param("end") LocalDate end);

    List<Emp> list2(@Param("name") String name, @Param("gender") Integer gender, @Param("begin") LocalDate begin, @Param("end") LocalDate end);

    void update2(Emp emp);

    //批量删除
    void deleteByIds(@Param("ids") List<Integer> ids);

    // 查询总记录数
    //@Select("select count(*) from emp")
    //public Long count();

    // 分页查询,获取列表数据
    //@Select("select * from emp limit #{start},#{pageSize}")
    //public List<Emp> page(Integer start, Integer pageSize);

    // 员工信息查询
    //@Select("select * from emp")
    List<Emp> list3(
            @Param("name") String name,
            @Param("gender") Integer gender,
            @Param("begin") LocalDate begin,
            @Param("end") LocalDate end
    );

    // 批量删除
    void delete3(@Param("ids") List<Integer> ids);
}
