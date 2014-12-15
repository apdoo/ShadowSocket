package com.hexor.util;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-10
 * Time: 上午2:35
 * To change this template use File | Settings | File Templates.
 */
public class ResponseUtil {
    public static void outWriteJson(HttpServletResponse response,Map  map) throws IOException{
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        //ƴװjson
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", map.get("msg"));
        jsonObject.put("count", map.get("count"));
        jsonObject.put("username", map.get("username"));
        jsonObject.put("datetime", map.get("datetime"));
        PrintWriter out = response.getWriter();
        out.write(jsonObject.toString());
    }
    public static void outWriteJsonMessage(HttpServletResponse response,Map  map) throws IOException{
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        //ƴװjson
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", map.get("msg"));
        PrintWriter out = response.getWriter();
//        System.out.println(jsonObject.toString());
        out.write(jsonObject.toString());

    }
    public static void outWriteJson(HttpServletResponse response,String json) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.write(json);
    }
    public static void outWriteErrorVcode() throws IOException{


    }
}
