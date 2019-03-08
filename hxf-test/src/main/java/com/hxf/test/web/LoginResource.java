package com.hxf.test.web;

import com.hxf.test.web.util.ResponseObject;
import com.hxf.test.web.util.ResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/6/14.
 */
@RestController
@RequestMapping("/api")
public class LoginResource {
    private final static Logger log = LoggerFactory.getLogger(LoginResource.class);
    private final static String name = "admin";
    private final static String pass = "123";

    @PostMapping("/login")
    public ResponseObject login(
            @RequestParam("userName") String userName,
            @RequestParam("passWord") String passWord
    ){
        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord)){
            return ResponseObject.failure(ResponseStatus.USER_PASS_NULL);
        }
        if(!name.equals(userName)|| !pass.equals(passWord)){
            return ResponseObject.failure(ResponseStatus.USER_NULL);
        }
        return ResponseObject.ok();
    }
}
