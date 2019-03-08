package com.itmuch.cloud.hxfitmuchcloudprovideruser.web;

import com.itmuch.cloud.hxfitmuchcloudprovideruser.domain.User;
import com.itmuch.cloud.hxfitmuchcloudprovideruser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/6/26.
 */
@RestController
@RequestMapping("/api")
public class UserResource {
    @Autowired
    private UserService userService;
    @GetMapping("/simple/{id}")
    public User findByOne(@PathVariable Long id){
        return  userService.findByOne(id);
    }
}
