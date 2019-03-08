package com.hxf.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ip地址白名单
 * Created by Administrator on 2018/3/22.
 */
public  class Env {
    public static final List<String> allowedOriginsHost = new ArrayList<>(
        Arrays.asList(
            "127.0.0.1",
            "localhost",
            "localhost:9527"
        )
    );

}
