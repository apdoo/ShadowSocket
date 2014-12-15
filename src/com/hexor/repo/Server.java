package com.hexor.repo;

/**
 * Created with IntelliJ IDEA.
 * User: Dong
 * Date: 14-12-9
 * Time: 下午12:11
 * To change this template use File | Settings | File Templates.
 */
public class Server {
    private int id;
    private String ip;
    private String addr;
    private String encryption;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getEncryption() {
        return encryption;
    }

    public void setEncryption(String encryption) {
        this.encryption = encryption;
    }
}
