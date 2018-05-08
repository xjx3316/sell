package com.sell2.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Created by xjx on 2018/4/18.
 */
public class KeyUtil {

    private static final Logger LOG = LoggerFactory.getLogger(KeyUtil.class);

    public synchronized static String genUniqueKey() {
        Random random = new Random();
        int i = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(i);
    }

    public static void main(String[] args) {
        LOG.info(genUniqueKey());
    }
}
