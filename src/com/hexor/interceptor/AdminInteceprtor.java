package com.hexor.interceptor;

import com.hexor.repo.User;
import com.hexor.util.Constant;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-14
 * Time: 下午6:07
 * To change this template use File | Settings | File Templates.
 */
public class AdminInteceprtor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        User user=(User)httpServletRequest.getSession().getAttribute(Constant.ADMIN_SESSION) ;
        if(user!=null){
        }else{
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/admin/login");
        }
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
