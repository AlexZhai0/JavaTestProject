package com.springboot_test.controller;

import com.springboot_test.bean.Address;
import com.springboot_test.bean.Result;
import com.springboot_test.bean.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("Hello Spring~");
        return "Hello Spring~";
    }

    /*//原始方式
    import javax.servlet.http.HttpServletRequest;
    @RequestMapping("/simpleParam")
    public String simpleParam(HttpServletRequest request) {
        // http://localhost:8080/simpleParam?name=Tom&age=10
        // 请求参数： name=Tom&age=10 （有2个请求参数）
        String name = request.getParameter("name");//name就是请求参数 名
        String ageStr = request.getParameter("age");//age就是请求参数 名
        int age = Integer.parseInt(ageStr);//需要手动进行类型转换
        System.out.println(name + " : " + age);
        return "OK";
    }*/

    //springboot方式
    //1. 简单参数
    //形参名和请求参数名保持一致
    //http://localhost:8080/simpleParam?name=Tom&age=10
    @RequestMapping("/simpleParam")
    public String simpleParam(@RequestParam(value = "name", required = false) String userName, Integer age) {
        //Tom : 10
        System.out.println(userName + " : " + age);
        return "OK";
    }

    //2. 实体参数
    //http://localhost:8080/simpleUser?name=Tom&age=10&address.city=上海
    @RequestMapping("/simpleUser")
    public String simpleUser(User user) {
        //User{name='Tom', age=10, address=Address{province='null', city='上海'}}
        System.out.println(user);
        return "OK";
    }

    //3. 数组集合参数
    //http://localhost:8080/arrayParam?hobby=zhangsan&hobby=zs
    //http://localhost:8080/arrayParam?hobby=zhangsan,zs1
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby) {
        //[zhangsan, zs1]
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }

    //http://localhost:8080/arrayParam?hobby=zhangsan&hobby=zs5
    //http://localhost:8080/listParam?hobby=zhangsan,zs3
    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby) {
        //[zhangsan, zs5]
        System.out.println(hobby);
        return "OK";
    }

    //4. 日期时间参数
    //http://localhost:8080/dateParam?updateTime=2023-08-11 10:05:45
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime) {
        //2023-08-11T10:05:45
        System.out.println(updateTime);
        return "OK";
    }

    //5. json参数，Post请求
    //http://localhost:8080/jsonParam
    //Post: {"name":"Tony","age":20,"address":{"city":"shanghai"}}
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user) {
        //User{name='Tony', age=20, address=Address{province='null', city='shanghai'}}
        System.out.println(user);
        return "OK";
    }

    //6. 路径参数
    //http://localhost:8080/path/1/5
    @RequestMapping("/path/{id}/{name}")
    public String pathParam(@PathVariable Integer id, @PathVariable String name) {
        // 1
        System.out.println(id);
        // 5
        System.out.println(name);
        return "OK";
    }

    //7. 统一返回
    //http://localhost:8080/getAddr
    @RequestMapping("/getAddr")
    public Result getAddr(){
        Address addr = new Address();
        addr.setProvince("广东");
        addr.setCity("深圳");
        //{"code":1,"msg":"success","data":{"province":"广东","city":"深圳"}}
        return Result.success(addr);
    }
}
