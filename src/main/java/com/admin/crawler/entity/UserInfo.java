package com.admin.crawler.entity;

import com.admin.crawler.annotations.*;

@OR
public class UserInfo {

    @LIKE @AND
    private String username;
    @EQ @AND
    private Long staffId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }
}
