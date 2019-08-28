package com.project.entity;

/**
 * @author zhuof
 * @company
 * @date 2019/8/23 14:30
 * @description
 */
public class User {
    private  String username;
    private  String password;
    private  String status;
    private  String qq;
    private  String registtime;

    public User() {
    }

    public User(String username, String password, String status, String qq, String registtime) {
        this.username = username;
        this.password = password;
        this.status = status;
        this.qq = qq;
        this.registtime = registtime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getRegisttime() {
        return registtime;
    }

    public void setRegisttime(String registtime) {
        this.registtime = registtime;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", qq='" + qq + '\'' +
                ", registtime='" + registtime + '\'' +
                '}';
    }
}
