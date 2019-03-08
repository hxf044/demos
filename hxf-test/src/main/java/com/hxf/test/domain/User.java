package com.hxf.test.domain;



import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 * Created by Administrator on 2018/3/19.
 */

public class User implements Serializable {

    private int id;

    private String username;

    private String password;

    private int state;

    private String avatar;

    private Date createTime;

    private Date updateTime;

    private int accountId;

    private String storesName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getStoresName() {
        return storesName;
    }

    public void setStoresName(String storesName) {
        this.storesName = storesName;
    }

    @Override
    public String toString() {
        return "StoresUserInfo{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", state=" + state +
            ", avatar='" + avatar + '\'' +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", accountId=" + accountId +
            ", storesName='" + storesName + '\'' +
            '}';
    }
}
