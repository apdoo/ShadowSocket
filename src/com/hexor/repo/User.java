package com.hexor.repo;

import com.hexor.util.CodeUtil;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Dong
 * Date: 14-12-9
 * Time: 下午12:06
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private int uid;
    private String user_name;
    private String email;
    private String pass;
    private String passwd= CodeUtil.getCode();
    private int t=0;
    private BigInteger u=new BigInteger("0");
    private BigInteger d=new BigInteger("0");
    private BigInteger transfer_enable=new BigInteger("30000000000");
    private int port;
    private int switch_;
    private int enable;
    private int type;
    private String last_get_gitf_time;
    private String last_rest_pass_time;
    private Timestamp reg_date;
    private String server="1,2,3";
    private int priv=0;
    private String temp;
    private  BigInteger s_t= new BigInteger("30000000000");

    public BigInteger getS_t() {
        return s_t;
    }

    public void setS_t(BigInteger s_t) {
        this.s_t = s_t;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }


    public BigInteger getTransfer_enable() {
        return transfer_enable;
    }

    public void setTransfer_enable(BigInteger transfer_enable) {
        this.transfer_enable = transfer_enable;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getSwitch_() {
        return switch_;
    }

    public void setSwitch_(int switch_) {
        this.switch_ = switch_;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLast_get_gitf_time() {
        return last_get_gitf_time;
    }

    public void setLast_get_gitf_time(String last_get_gitf_time) {
        this.last_get_gitf_time = last_get_gitf_time;
    }

    public String getLast_rest_pass_time() {
        return last_rest_pass_time;
    }

    public void setLast_rest_pass_time(String last_rest_pass_time) {
        this.last_rest_pass_time = last_rest_pass_time;
    }

    public BigInteger getU() {
        return u;
    }

    public void setU(BigInteger u) {
        this.u = u;
    }

    public BigInteger getD() {
        return d;
    }

    public void setD(BigInteger d) {
        this.d = d;
    }

    public Timestamp getReg_date() {
        return reg_date;
    }

    public void setReg_date(Timestamp reg_date) {
        this.reg_date = reg_date;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getPriv() {
        return priv;
    }

    public void setPriv(int priv) {
        this.priv = priv;
    }
}
