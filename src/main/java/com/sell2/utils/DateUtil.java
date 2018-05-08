package com.sell2.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xjx on 2018/4/16.
 */
public class DateUtil {

    public static String getNow(){
        Date date = new Date();
        SimpleDateFormat dsf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dsf.format(date);
    }
}
