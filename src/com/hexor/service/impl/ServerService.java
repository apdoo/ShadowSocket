package com.hexor.service.impl;

import com.hexor.dao.IServerMapper;
import com.hexor.repo.Pager;
import com.hexor.repo.Server;
import com.hexor.service.IServerService;
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
@Service("com.hexor.service.impl.ServerService")
public class ServerService implements IServerService {

    @Autowired
    @Qualifier("com.hexor.dao.IServerMapper")
    private IServerMapper mapper;
    public void setMapper(IServerMapper delegate) {
        this.mapper = delegate;
    }

    @Override
    public List<Server> getAllServer() {
        return mapper.getAllServer();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Server selectServById(String id) {
        return mapper.selectServById(id);
    }

    @Override
    public long getServerCount() {
        return mapper.getServerCount();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Server> limit(Pager pager) {
        return mapper.limit(pager);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void insertServer(Server server) {
        mapper.insertServer(server);//To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateServer(Server server) {
        mapper.updateServer(server);//To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Server getServerById(int id) {
        return mapper.getServerById(id);
    }

    @Override
    public void deleteById(int id) {
        mapper.deleteById(id);
    }


}
