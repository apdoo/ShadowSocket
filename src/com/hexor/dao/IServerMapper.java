package com.hexor.dao;

import com.hexor.repo.Pager;
import com.hexor.repo.Server;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dong
 * Date: 14-8-27
 * Time: 下午2:49
 * To change this template use File | Settings | File Templates.
 */
@Service("com.hexor.dao.IServerMapper")
public interface IServerMapper {
    public List<Server> getAllServer() ;
    public Server selectServById(String id);
    public long getServerCount();
    public List<Server> limit(Pager pager);
    public void insertServer(Server server);
    public void updateServer(Server server);
    public Server getServerById(int id);
    public void deleteById(int id);
}
