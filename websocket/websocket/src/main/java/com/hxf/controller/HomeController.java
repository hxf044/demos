package com.hxf.controller;


import com.hxf.controller.utils.ResponseObject;
import com.hxf.service.SocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * websocket
 * 消息推送(个人和广播)
 */
@RestController
@RequestMapping("/")
public class HomeController {
    @GetMapping("/")
    public ResponseObject index() {
        return ResponseObject.ok();
    }


}
