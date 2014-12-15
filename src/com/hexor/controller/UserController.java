package com.hexor.controller;

import com.hexor.repo.Server;
import com.hexor.repo.User;
import com.hexor.service.impl.ServerService;
import com.hexor.service.impl.UserService;
import com.hexor.util.*;
import net.sf.json.JSONArray;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-10
 * Time: 上午1:29
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value="user")
public class UserController {

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

    /**
     * 注册接口
     * @param request
     * @param session
     * @param response
     */
    @RequestMapping(value="reg")
    public ModelAndView reg(User user,HttpServletRequest request,HttpSession session, HttpServletResponse response){
        User result=userService.checkUserExist(user.getUser_name());
        //邀请码填写错误的时候
        if(!Constant.CODE.equals(user.getTemp())){
            return new ModelAndView("messagetips",ModelMapUtil.getMsg(EncodingTool.encodeStr("Invite code Does not exist", "ISO-8859-1")));
        }
        //当数据库中存在同名用户的时候
        if(result!=null){
            return new ModelAndView("messagetips",ModelMapUtil.getMsg(EncodingTool.encodeStr("username  already exists", "ISO-8859-1")));
        }
        try{
            Timestamp timeStamp = new Timestamp(new Date().getTime());
            user.setReg_date(timeStamp);
            user.setPort(userService.getMaxProt()+1);
            user.setPass(MD5Util.string2MD5(user.getPass()));
            userService.insertUser(user);
        }catch (Exception e){
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.setViewName("messagetips");
            modelAndView.addObject("msg", EncodingTool.encodeStr("reg error,please try again", "ISO-8859-1"));
            return modelAndView;
        }
        session.setAttribute(Constant.USER_SESSION, user);
        user.setS_t(user.getTransfer_enable().subtract(user.getU().add(user.getD())).divide(new BigInteger("1000000")));
        user.setTransfer_enable(user.getTransfer_enable().divide(new BigInteger("1000000000")));
        user.setU(user.getU().divide(new BigInteger("1000000")));
        user.setD(user.getD().divide(new BigInteger("1000000")));
        Date d = new Date(user.getT()*1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setTemp(sdf.format(d));
        ModelAndView modelAndView=new ModelAndView("myindex", ModelMapUtil.getUserMap(user)) ;
        return modelAndView;
    }
    /**
     * 登录接口
     * @return
     */
    @RequestMapping(value="login")
    public ModelAndView login(User user,HttpSession session,HttpServletRequest request){
        //加密user密码
        user.setPass(MD5Util.string2MD5(user.getPass()));
        User result=userService.checkLogin(user);
        //当数据库检验用户名密码
        if(result==null){
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.setViewName("messagetips");
            modelAndView.addObject("msg", EncodingTool.encodeStr("Incorrect username or password", "ISO-8859-1"));
            return modelAndView;
        }
        //设置登陆时间
        session.setAttribute(Constant.USER_SESSION, result);
        Date d = new Date(result.getT()*1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        result.setTemp(sdf.format(d));
        result.setS_t(result.getTransfer_enable().subtract(result.getU().add(result.getD())).divide(new BigInteger("1000000")));
        result.setTransfer_enable(result.getTransfer_enable().divide(new BigInteger("1000000000")));
        result.setU(result.getU().divide(new BigInteger("1000000")));
        result.setD(result.getD().divide(new BigInteger("1000000")));
        ModelAndView modelAndView=new ModelAndView("myindex", ModelMapUtil.getUserMap(result)) ;
        return modelAndView;
    }

    /**
     * 退出接口
     * @param session
     * @return
     */
    @RequestMapping(value="exit")
    public void exit(HttpSession session,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException {
        session.removeAttribute(Constant.USER_SESSION);
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/index.jsp");
    }
    /**
     * 获得server列表
     * @param ids
     * @param request
     * @param session
     * @param response
     * @return
     */
    @RequestMapping(value="server")
    public void server(@RequestParam(value = "ids")String ids,HttpServletRequest request,HttpSession session, HttpServletResponse response) throws IOException {
        JSONObject json=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        json.put(Constant.SUCCESS,true);
        String temp[]=ids.split(",");
        for(int i=0;i<temp.length;i++){
           Server server =serverService.selectServById(temp[i]);
            jsonArray.add(server);
        }
        json.put("data",jsonArray);
        ResponseUtil.outWriteJson(response,json.toString());
    }
    /**
     * test
     * @param session
     * @param response
     * @return
     */
    @RequestMapping(value="doModify")
    public ModelAndView doModify(@RequestParam(value = "pass")String pass,@RequestParam(value = "enpass")String enpass,HttpSession session, HttpServletResponse response,HttpServletRequest httpServletRequest){
         if(!pass.equals(enpass)){
             ModelAndView modelAndView=new ModelAndView();
             modelAndView.setViewName("messagetips");
             modelAndView.addObject("msg", EncodingTool.encodeStr("Enter the new password twice inconsistent", "ISO-8859-1"));
             return modelAndView;
         }
        User user=(User)httpServletRequest.getSession().getAttribute(Constant.USER_SESSION) ;
        user.setPass(MD5Util.string2MD5(pass));
        userService.updateUser(user);
        //设置登陆时间
        session.setAttribute(Constant.USER_SESSION, user);
        user.setS_t(user.getTransfer_enable().subtract(user.getU().add(user.getD())));
        ModelAndView modelAndView=new ModelAndView("myindex", ModelMapUtil.getUserMap(user)) ;
        return modelAndView;
    }
    /**
     * test
     * @param session
     * @param response
     * @return
     */
    @RequestMapping(value="getUsers")
    public void login(HttpSession session, HttpServletResponse response){
        JSONObject json=new JSONObject();
        List<User> list=userService.getAllUsers();
        System.out.println(list.size()+".."+list.get(0).toString());
        json.put(Constant.SUCCESS,true);
        json.put("data", JSONArray.fromObject(list));
        try {
            ResponseUtil.outWriteJson(response, json.toString());
        } catch (IOException e) {
        }
    }
    @RequestMapping(value="refresh")
    public void refresh(@RequestParam(value = "uid")String uid,HttpSession session, HttpServletResponse response){
        User user=userService.getUserById(Integer.parseInt(uid));
        user.setS_t(user.getTransfer_enable().subtract(user.getU().add(user.getD())).divide(new BigInteger("1000000")));
        user.setTransfer_enable(user.getTransfer_enable().divide(new BigInteger("1000000000")));
        user.setU(user.getU().divide(new BigInteger("1000000")));
        user.setD(user.getD().divide(new BigInteger("1000000")));
        Date d = new Date(user.getT()*1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setTemp(sdf.format(d));
        JSONObject json=new JSONObject();
        json.put(Constant.SUCCESS,false);

        if(user!=null){
            try {
                json.put(Constant.SUCCESS,true);
                json.put("data",user);
                ResponseUtil.outWriteJson(response, json.toString());
            } catch (IOException e) {
            }
        }
    }
    @RequestMapping(value="refreshProt")
    public void refreshProt(@RequestParam(value = "uid")String uid,HttpSession session, HttpServletResponse response) throws IOException {
         int port=RandUtil.getRandPort();
        User temp=userService.checkPort(port);
        JSONObject json=new JSONObject();
        json.put(Constant.SUCCESS,false);
        if(temp==null){
            //当前端口不存在
            User user=userService.getUserById(Integer.parseInt(uid));
            user.setPort(port);
            userService.updateUser(user);
            json.put(Constant.SUCCESS,true);
            json.put("data",user);
            ResponseUtil.outWriteJson(response, json.toString());
        }
    }
    @RequestMapping(value="refreshPass")
    public void refreshPass(@RequestParam(value = "uid")String uid,HttpSession session, HttpServletResponse response) throws IOException {
            User user=userService.getUserById(Integer.parseInt(uid));
        JSONObject json=new JSONObject();
        json.put(Constant.SUCCESS,true);
            user.setPasswd(CodeUtil.getCode());
            userService.updateUser(user);
        json.put("data",user);
        ResponseUtil.outWriteJson(response, json.toString());
    }

}
