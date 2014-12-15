package com.hexor.util;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-10
 * Time: 上午7:29
 * To change this template use File | Settings | File Templates.
 */
import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class MD5Util {

    public static String string2MD5(String inStr){
        MessageDigest md5 = null;
        try{
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++){
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }


    public static String convertMD5(String inStr){

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++){
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }

    public static void main(String args[]) {
        String s = new String("pwd");
        System.out.println("r" + s);
        System.out.println("MD5 " + string2MD5(s));
        System.out.println("m" + convertMD5(s));
        System.out.println("j" + convertMD5(convertMD5(s)));
        System.out.println("j" + convertMD5("9003d1df22eb4d3820015070385194c8"));
    }
}
