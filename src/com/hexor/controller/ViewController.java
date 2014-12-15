package com.hexor.controller;

import com.hexor.repo.User;
import com.hexor.util.Constant;
import com.hexor.util.ModelMapUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-14
 * Time: 下午5:03
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ViewController {
    @RequestMapping(value="login")
    public ModelAndView  login(HttpServletRequest request,HttpSession session, HttpServletResponse response){
        //判断session跳转
        User suser=(User)request.getSession().getAttribute(Constant.USER_SESSION) ;
        if(suser!=null){
            ModelAndView modelAndView=new ModelAndView("myindex", ModelMapUtil.getUserMap(suser)) ;
            return modelAndView;
        }
        return new ModelAndView("login");
    }
    @RequestMapping(value="reg")
    public String  reg(HttpServletRequest request,HttpSession session, HttpServletResponse response){
        return "reg";
    }
    @RequestMapping(value="client")
    public String  client(HttpServletRequest request,HttpSession session, HttpServletResponse response){
        return "client";
    }

    @RequestMapping(value="myindex")
    public String  myindex(HttpServletRequest request,HttpSession session, HttpServletResponse response){
        return "myindex";
    }

    @RequestMapping(value="modify")
    public String modify(HttpSession session, HttpServletResponse response){
        return "modify";
    }
}
