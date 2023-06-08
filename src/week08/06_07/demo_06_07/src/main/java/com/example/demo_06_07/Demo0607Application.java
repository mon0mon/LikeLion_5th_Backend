package com.example.demo_06_07;

import com.example.demo_06_07.yes.very.deep.pack.DeepComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@EnableAutoConfiguration
//@ComponentScan
//@ComponentScan(basePackages = "com.example.demo_06_07")
//@ComponentScan(basePackages = "com.example.demo_06_07.yes")
//@ComponentScan(basePackages = {
//    "com.example.demo_06_07.yes",
//    "com.example.demo_06_07.temp",
//})
@ComponentScan(basePackageClasses = DeepComponent.class)
public class Demo0607Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Demo0607Application.class,
            args);

        for (String name : applicationContext.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }

}
