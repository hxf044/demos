package com.hxf.test.web.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;

/**
 * @author peanut   angerpeanut@gmail.com
 * @since 1.0
 */
public class ResponseInnerListObject implements Serializable {

    private static final long serialVersionUID = -4749514468410191479L;

    private static Logger logger = LoggerFactory.getLogger(ResponseInnerListObject.class);

    private List list;

    public ResponseInnerListObject(List list) {
        this.list = list;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public static ResponseInnerListObject instance(List list) {
        if (list.isEmpty()) {
            return null;
        }
        return new ResponseInnerListObject(list);
    }

}
