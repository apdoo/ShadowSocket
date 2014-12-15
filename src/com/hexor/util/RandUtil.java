package com.hexor.util;

/**
 * Created with IntelliJ IDEA.
 * User: Dong
 * Date: 14-12-15
 * Time: 下午5:16
 * To change this template use File | Settings | File Templates.
 */
public class RandUtil {
    public static int getRandPort(){

        return  (int)(Math.random()*10000)+50000;
    }

    public static void main(String[] args) {
        System.out.println(getRandPort());
    }
}
