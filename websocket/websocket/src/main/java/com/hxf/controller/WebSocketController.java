package com.hxf.controller;


import com.hxf.controller.utils.ResponseObject;
import com.hxf.service.SocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * websocket
 * 消息推送(个人和广播)
 */
@RestController
@RequestMapping("/api/socket")
public class WebSocketController {
    @Autowired
    private SocketServer socketServer;


    @GetMapping("/admin")
    public ResponseObject admin(Model model) {
        int num = SocketServer.getOnlineNum();
        String str = SocketServer.getUsers();
        return ResponseObject.ok();
    }

    /**
     * 个人信息推送
     * @return
     */
    @GetMapping("/sendmsg")
    public ResponseObject sendmsg(String msg, String username){
        String [] persons = username.split(",");
        SocketServer.sendMany(msg,persons);
        return ResponseObject.ok();
    }


    @GetMapping("/sendAll")
    public ResponseObject sendAll(String msg){
        SocketServer.sendMessageAll(msg);
        return ResponseObject.ok();
    }

    @GetMapping("/webstatus")
    public ResponseObject webstatus(){
        //当前用户个数
       int count = SocketServer.getOnlineNum();
       //当前用户的username
       SocketServer.getUsers();
       return ResponseObject.ok();
    }
}
