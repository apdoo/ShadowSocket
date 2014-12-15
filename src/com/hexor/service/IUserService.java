package com.hexor.service;

import com.hexor.repo.Pager;
import com.hexor.repo.Server;
import com.hexor.repo.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dong
 * Date: 14-8-27
 * Time: 下午3:06
 * To change this template use File | Settings | File Templates.
 */
public interface IUserService {

    public List<User> getAllUsers();
    public User  checkLogin(User user);
    public int getMaxProt();
    public void insertUser(User user);
    public User checkUserExist(String username);
    public User getUserById(int uid);
    public long getUsersCount();
    public List<User> limit(Pager pager);
    public void updateUser(User user);
    public void deleteById(int id);
    public void userTask();
    public User checkPort(int port);
}
