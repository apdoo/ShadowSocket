package com.hexor.dao;

import com.hexor.repo.Pager;
import com.hexor.repo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-10
 * Time: 上午1:30
 * To change this template use File | Settings | File Templates.
 */
@Service("com.hexor.dao.IUserMapper")
public interface IUserMapper {
    public List<User> getAllUsers();
    public User checkLogin(User user);
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
