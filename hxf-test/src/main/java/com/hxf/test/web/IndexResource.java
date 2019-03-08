package com.hxf.test.web;

import com.hxf.test.web.util.ResponseObject;
import com.hxf.test.web.util.ResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/6/14.
 */
@RestController
@RequestMapping("/")
public class IndexResource {
    private final static Logger log = LoggerFactory.getLogger(IndexResource.class);

    @GetMapping("/")
    public String index(){
       return "hello Word";
    }
}
