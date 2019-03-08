package com.hxf.scheduled;


import com.hxf.service.SocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2018/10/22.
 */
@Service
public class TestScheduled {
    private final Logger log = LoggerFactory.getLogger(TestScheduled.class);

    @Scheduled(cron="0/10 * * * * ?")
    public void test(){
        String  format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        SocketServer.sendMessageAll("当前时间:"+ sdf.format(System.currentTimeMillis()));
    }

}
