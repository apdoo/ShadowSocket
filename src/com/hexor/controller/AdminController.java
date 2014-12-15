package com.hexor.controller;

import com.hexor.repo.Pager;
import com.hexor.repo.Server;
import com.hexor.repo.User;
import com.hexor.service.impl.ServerService;
import com.hexor.service.impl.UserService;
import com.hexor.util.*;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Dong
 * Date: 14-9-12
 * Time: 下午3:11
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value="admin")
public class AdminController {
    @Autowired
    @Qualifier("com.hexor.service.impl.UserService")
    private UserService userService = null;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    @Qualifier("com.hexor.service.impl.ServerService")
    private ServerService serverService = null;
    public void setServerService(ServerService serverService) {
        this.serverService = serverService;
    }

    @RequestMapping(value="login")
    public ModelAndView login(HttpSession session, ModelMap model){
        return new ModelAndView("admin/login");
    }

    @RequestMapping(value="home")
    public ModelAndView home(HttpSession session, ModelMap model){
        return new ModelAndView("admin/home");
    }

    @RequestMapping(value="usermanage")
    public ModelAndView usermanage(HttpSession session, ModelMap model){
        return new ModelAndView("admin/usermanage");
    }
    @RequestMapping(value="serversmanage")
    public ModelAndView serversmanage(HttpSession session, ModelMap model){
        return new ModelAndView("admin/serversmanage");
    }

    @RequestMapping(value="doLogin")
    public ModelAndView doLogin(User user,HttpSession session, ModelMap model){
        user.setPass(MD5Util.string2MD5(user.getPass()));
        User result=userService.checkLogin(user);
        if(result==null){
            Map map= ModelMapUtil.getMsg("wrong account or password");
            return new ModelAndView("admin/login",map);
        }
        if(result.getPriv()!=1){
            Map map= ModelMapUtil.getMsg("this account not admin account");
            return new ModelAndView("admin/login",map);
        }
        session.setAttribute(Constant.ADMIN_SESSION, result);
        return new ModelAndView("admin/home");
    }
    @RequestMapping(value = "getUserInfo")
    public void  getUserInfo(HttpServletResponse response,@RequestParam (value = "id")String id){
        User user=userService.getUserById(Integer.parseInt(id));
        user.setTransfer_enable(user.getTransfer_enable().divide(new BigInteger("1000000000")));
        user.setU(user.getU().divide(new BigInteger("1000000000")));
        user.setD(user.getD().divide(new BigInteger("1000000000")));
        JSONObject json=new JSONObject();
        if(user!=null){
            json= JSONObject.fromObject(user);
            System.out.println(json.toString());
        }
        try {
            ResponseUtil.outWriteJson(response,json.toString());
        } catch (IOException e) {
        }

    }
    @RequestMapping(value = "updateUser")
    public void updateUser(User user,HttpServletResponse response){
        System.out.println(user.toString());
        user.setPass(user.getPass());
        user.setTransfer_enable(user.getTransfer_enable().multiply(new BigInteger("1000000000")));
        JSONObject json = new JSONObject();
        json.put(Constant.SUCCESS,true);
        userService.updateUser(user);
        try {
            ResponseUtil.outWriteJson(response,json.toString());
        } catch (IOException e) {
        }
    }

    @RequestMapping(value = "getUsers")
    public void getUsers(@RequestParam(value = "page")String page,@RequestParam(value = "rows")String rows, HttpServletResponse response,HttpServletRequest request){
        System.out.println("page:"+page+"rows:"+rows);
        Map map = new HashMap();
        Pager pager=new Pager();
        long count=userService.getUsersCount();
        pager.setData(Integer.parseInt(rows));
        pager= PagerUtil.build(PagerUtil.SetPager(pager, count, Integer.parseInt(page)));
        List<User> list=userService.limit(pager);
        if(list!=null&&list.size()>0){
            for(int i=0;i<list.size();i++){
                list.get(i).setTransfer_enable(list.get(i).getTransfer_enable().divide(new BigInteger("1000000000")));
                list.get(i).setU(list.get(i).getU().divide(new BigInteger("1000000")));
                list.get(i).setD(list.get(i).getD().divide(new BigInteger("1000000")));
            }

        }
        map.put("total", count);
        map.put("rows", list);
        JSONObject json = new JSONObject();
        json=JSONObject.fromObject(map);
        System.out.println("--------"+json.toString());
        try {
            ResponseUtil.outWriteJson(response, json.toString());
        } catch (IOException e) {
        }
    }

    @RequestMapping(value = "getServers")
    public void getServers(@RequestParam(value = "page")String page,@RequestParam(value = "rows")String rows, HttpServletResponse response,HttpServletRequest request){
        System.out.println("page:"+page+"rows:"+rows);
        Map map = new HashMap();
        Pager pager=new Pager();
        long count=serverService.getServerCount();
        pager.setData(Integer.parseInt(rows));
        pager= PagerUtil.build(PagerUtil.SetPager(pager, count, Integer.parseInt(page)));
        List<Server> list=serverService.limit(pager);
        map.put("total", count);
        map.put("rows", list);
        JSONObject json = new JSONObject();
        json=JSONObject.fromObject(map);
        System.out.println("--------"+json.toString());
        try {
            ResponseUtil.outWriteJson(response, json.toString());
        } catch (IOException e) {
        }
    }
    @RequestMapping(value = "updateServer")
    public void updateServer(Server server,HttpServletResponse response){
        System.out.println(server.toString());
        JSONObject json = new JSONObject();
        json.put(Constant.SUCCESS,true);
        serverService.updateServer(server);
        try {
            ResponseUtil.outWriteJson(response,json.toString());
        } catch (IOException e) {
        }
    }
    @RequestMapping(value = "getServerInfo")
    public void  getServerInfo(HttpServletResponse response,@RequestParam (value = "id")String id){
        Server server=serverService.getServerById(Integer.parseInt(id));
        JSONObject json=new JSONObject();
        if(server!=null){
            json= JSONObject.fromObject(server);
            System.out.println(json.toString());
        }
        try {
            ResponseUtil.outWriteJson(response,json.toString());
        } catch (IOException e) {
        }
    }
    @RequestMapping(value = "insertServer")
    public void  insertServer(Server server,HttpServletResponse response) throws IOException {
        JSONObject json=new JSONObject();
        json.put(Constant.SUCCESS,true);
        try{
            serverService.insertServer(server);
        }catch (Exception e){
            json.put(Constant.SUCCESS,false);
        }
       ResponseUtil.outWriteJson(response,json.toString());
    }

    @RequestMapping(value = "deleteServer")
    public void  deleteServer(@RequestParam (value = "id")String id,HttpServletResponse response) throws IOException {
        JSONObject json=new JSONObject();
        json.put(Constant.SUCCESS,true);
        try{
            serverService.deleteById(Integer.parseInt(id));
        }catch (Exception e){
            json.put(Constant.SUCCESS,false);
        }
        ResponseUtil.outWriteJson(response,json.toString());
    }
    @RequestMapping(value = "deleteUser")
    public void  deleteUser(@RequestParam (value = "id")String id,HttpServletResponse response) throws IOException {
        JSONObject json=new JSONObject();
        json.put(Constant.SUCCESS,true);
        try{
            userService.deleteById(Integer.parseInt(id));
        }catch (Exception e){
            json.put(Constant.SUCCESS,false);
        }
        ResponseUtil.outWriteJson(response,json.toString());
    }

    @RequestMapping(value="addUser")
    public void reg(User user,HttpServletRequest request,HttpSession session, HttpServletResponse response) throws IOException {
        User result=userService.checkUserExist(user.getUser_name());
        JSONObject json=new JSONObject();
        json.put(Constant.SUCCESS,false);
        //当数据库中不存在同名用户的时候
        if(result==null){
            json.put(Constant.SUCCESS,true);
        try{
            Timestamp timeStamp = new Timestamp(new Date().getTime());
            user.setReg_date(timeStamp);
            user.setPort(userService.getMaxProt()+1);
            user.setPass(MD5Util.string2MD5(user.getPass()));
            userService.insertUser(user);
        }catch (Exception e){
            json.put(Constant.SUCCESS,false);
        }
        }
        ResponseUtil.outWriteJson(response,json.toString());

    }
}
