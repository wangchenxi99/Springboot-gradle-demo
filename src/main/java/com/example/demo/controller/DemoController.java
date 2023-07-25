package com.example.demo.controller;

import com.example.demo.entity.UserDemo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello,Word";
    }

    @PostMapping("/insertDemo")
    public String insertDataDemo(@RequestBody UserDemo userDemo){
        System.out.println(userDemo.getName());
        System.out.println(userDemo.getAge());
        return "insert Demo";
    }

    private void test() {
        System.out.println("test1before23232");
    }

}
