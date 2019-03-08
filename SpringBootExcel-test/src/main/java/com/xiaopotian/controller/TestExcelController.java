package com.xiaopotian.controller;

import com.xiaopotian.utils.RandomValue;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class TestExcelController {
    private final  static int num = 36;
    public static void excel() throws Exception {
        ExcelData data = new ExcelData();
        data.setName("hello");
        List<String> titles = new ArrayList();
        titles.add("姓名");
        titles.add("手机号");
        titles.add("性别");
        titles.add("公司");
        titles.add("职位");
        titles.add("标签");
        data.setTitles(titles);

        List<List<Object>> rows = new ArrayList();


        for (int i=0;i<num;i++){
            rows.add(RandomValue.getXinXi());
        }
        data.setRows(rows);
        //本地生成
        File f = new File("E:/shuju/"+num+"条全面测试数据"+Calendar.getInstance().getTimeInMillis()+".xlsx");
        FileOutputStream out = new FileOutputStream(f);
        ExportExcelUtils.exportExcel(data, out);
        out.close();
    }

    public static void main(String[] args) throws Exception {
        TestExcelController.excel();
    }
}
