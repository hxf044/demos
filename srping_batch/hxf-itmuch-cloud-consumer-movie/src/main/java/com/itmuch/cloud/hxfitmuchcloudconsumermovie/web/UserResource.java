package com.itmuch.cloud.hxfitmuchcloudconsumermovie.web;


import com.itmuch.cloud.hxfitmuchcloudconsumermovie.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2018/6/26.
 */
@RestController
@RequestMapping("/api")
public class UserResource {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${user.userServicePath}")
    private String userServicePath;
    @GetMapping("/movie/{id}")
    public UserDTO findByOne(@PathVariable Long id){
        return  restTemplate.getForObject(this.userServicePath+id ,UserDTO.class);
    }
}
