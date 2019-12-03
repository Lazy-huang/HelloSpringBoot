package com.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mycls.pojo.SpringConfig;
import com.mycls.pojo.User;
import com.mycls.service.UserService;

public class Main {
	public static void main(String[] args) {
		 // 通过Java配置来实例化Spring容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        //实例化一个类，把标记为@Configuration的类作为配置项参数传递进去
        // 在Spring容器中获取Bean对象
        UserService userService = context.getBean(UserService.class);
        // 调用对象中的方法
        List<User> list = userService.queryUserList();
        for (User user : list) {
            System.out.println(user.getUsername() + ", " + user.getPassword() + ", " + user.getAge());
        }
        // 销毁该容器
        context.destroy();

    }

}
