package com.hxf.test.web;

import com.hxf.test.domain.User;
import com.hxf.test.web.util.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */
@RestController
@RequestMapping("/api")
public class HomeResource {
    private final static Logger log = LoggerFactory.getLogger(LoginResource.class);
    private final static String name = "admin";
    private final static String pass = "123";

    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello,Spring Boot";
    }
    @GetMapping("/index")
    public ResponseObject index( ){
        List<User> list = new ArrayList<>();
        for (int i=1;i<=10;i++){
            User user = new User();
            user.setAccountId(1000000+i);
            user.setAvatar("http://img.zcool.cn/community/01f8d956cbb9aa32f875520fe36c11.jpg@900w_1l_2o_100sh.jpg");
            user.setCreateTime(new Date());
            user.setId(i);
            user.setPassword("123");
            user.setState(1);
            user.setStoresName("七格格");
            user.setUpdateTime(new Date());
            user.setUsername("何小飞"+i+"号");
            list.add(user);
        }
        return ResponseObject.ok(list);
    }
}
