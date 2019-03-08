package com.hxf.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2018/10/22.
 */
@ServerEndpoint(value = "/socketServer/{name}")
@Component
public class SocketServer {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    private Session session;
    //websocket session集合
    private static Map<String,Session> sessions = new HashMap<String,Session>();
    private static Map<String,String> naems = new HashMap<String,String>();

    //建立连接
    @OnOpen
    public void open(Session session,@PathParam("name")String name){
        this.session = session;
        sessions.put(name,session);
        naems.put(this.session.getId(),name);
    }
    //接受消息+
    @OnMessage
    public void message(String  msg){

    }
    //关闭连接
    @OnClose
    public void close(){
        sessions.remove(naems.get(session.getId()));
    }
    //错误提示
    @OnError
    public void error(Session session, Throwable error) {
        log.info("Session {},error {}",session,error);
    }

    //发送一条信息
    public static void sendMessage(String message,String name){
        Session s = sessions.get(name);
        if(s!=null){
            try {
                s.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //群发
    public static void sendMessageAll(String message){
        for (String key:sessions.keySet()){
            if(!"hxf".equals(key)){
                sendMessage(message,key);
            }
        }
    }
    //获取当前人数
    public static int getOnlineNum(){
        if(sessions.keySet().contains("hxf")) {
            return sessions.size()-1;
        }
        return sessions.size();
    }

    //获取用户信息
    public static String getUsers(){
        Set<String> names = sessions.keySet();
        if(names!= null){
            StringBuffer users = new StringBuffer();
           return names.stream().filter(s-> !s.equals("hxf")).collect(Collectors.joining(","));
        }
        return "";
    }

    public static void sendMany(String msg,String [] persons) {
        for (String name : persons) {
            sendMessage(msg, name);
        }

    }

}
