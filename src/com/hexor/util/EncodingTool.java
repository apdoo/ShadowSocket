package com.hexor.util;

import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-10
 * Time: 上午2:56
 * To change this template use File | Settings | File Templates.
 */
public class EncodingTool {

    public static String encodeStr(String str,String type) {
        try {
            return new String(str.getBytes(type), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
