package com.hexor.repo;

/**
 * Created with IntelliJ IDEA.
 * User: Dong
 * Date: 14-12-9
 * Time: 下午12:07
 * To change this template use File | Settings | File Templates.
 */
public class InviteCode {
    private int id;
    private String code;
    private int user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
}
