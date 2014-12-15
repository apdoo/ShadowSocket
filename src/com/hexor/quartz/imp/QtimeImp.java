package com.hexor.quartz.imp;

import com.hexor.quartz.QtimeInterface;
import com.hexor.service.impl.UserService;
import com.hexor.util.DateUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class QtimeImp implements QtimeInterface{
	Logger logger = Logger.getLogger(QtimeImp.class);
    @Autowired
    @Qualifier("com.hexor.service.impl.UserService")
    private UserService userService = null;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Scheduled(cron="0 15 10 1 * ? ")
    public void test() {
		 logger.warn("logger当前定时器执行时间:" + DateUtil.getStrOfDateTime());
         //清除上传下载流量
         userService.userTask();
	}

}
