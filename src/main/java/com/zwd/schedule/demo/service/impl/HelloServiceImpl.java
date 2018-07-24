package com.zwd.schedule.demo.service.impl;


import com.zwd.schedule.demo.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author zwd
 * @date 2018/7/23 19:55
 * @Email stephen.zwd@gmail.com
 */
@Service
public class HelloServiceImpl implements HelloService{
    @Override
    public void sayHello(String content) {
        System.out.println(content);
    }
}
