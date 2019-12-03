package com.test;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
@Configuration
public class HelloApplication {
    @RequestMapping("hello")
    @ResponseBody  //使用消息转发器输出这个结果
    public String hello(){
        return "hello world！";
}
    
//入口方法
public static void main(String[] args) {
	//运行的这个应用一定要包含@SpringBootApplication注解
        SpringApplication.run(HelloApplication.class, args);
    }
}

