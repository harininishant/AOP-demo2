package com.example.aopdemo2;

import com.example.aopdemo2.service.DummyService;
import com.example.aopdemo2.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class AopDemo2Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AopDemo2Application.class, args);
        DummyService dummyService = context.getBean(DummyService.class);
        System.out.println(dummyService.getName("data"));
      dummyService.doSomething("uma",1);
        StudentService studentService = context.getBean(StudentService.class);
        studentService.M1();
    }
}
