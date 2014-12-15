package com.hexor.service.impl;

import com.hexor.dao.IUserMapper;
import com.hexor.repo.Pager;
import com.hexor.repo.User;
import com.hexor.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dong
 * Date: 14-8-27
 * Time: 下午4:08
 * To change this template use File | Settings | File Templates.
 */
@Service("com.hexor.service.impl.UserService")
public class UserService implements IUserService {

    @Autowired
    @Qualifier("com.hexor.dao.IUserMapper")
    private IUserMapper mapper;
    public void setMapper(IUserMapper delegate) {
        this.mapper = delegate;
    }

    @Override
    public List<User> getAllUsers() {
        return mapper.getAllUsers();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public User checkLogin(User user) {
        return mapper.checkLogin(user);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getMaxProt() {
        return mapper.getMaxProt();
    }

    @Override
    public void insertUser(User user) {
        mapper.insertUser(user);
    }

    @Override
    public User checkUserExist(String username) {
        return mapper.checkUserExist(username);
    }

    @Override
    public User getUserById(int uid) {
        return mapper.getUserById(uid);
    }

    @Override
    public long getUsersCount() {
        return mapper.getUsersCount();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<User> limit(Pager pager) {
        return mapper.limit(pager);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateUser(User user) {
        mapper.updateUser(user);//To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteById(int id) {
        mapper.deleteById(id);
    }

    @Override
    public void userTask() {
        mapper.userTask();
    }

    @Override
    public User checkPort(int port) {
        return mapper.checkPort(port);
    }
}
