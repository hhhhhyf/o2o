package com.cjlu.o2o.entity;

import javax.xml.crypto.Data;
import java.util.Date;

public class LocalAuth {
    private Long localAuthId;
    private String username;
    private String password;
    private Data createTime;
    private Date lastEditTime;
    private PersonInfo persinInfo;

    public Long getLocalAuthId() {
        return localAuthId;
    }

    public void setLocalAuthId(Long localAuthId) {
        this.localAuthId = localAuthId;
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

    public Data getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Data createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public PersonInfo getPersinInfo() {
        return persinInfo;
    }

    public void setPersinInfo(PersonInfo persinInfo) {
        this.persinInfo = persinInfo;
    }
}
