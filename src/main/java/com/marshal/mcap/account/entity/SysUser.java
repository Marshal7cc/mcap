package com.marshal.mcap.account.entity;

import java.util.Date;

public class SysUser {
    private Long userId;

    private String userType;

    private String userName;

    private String passwordEncrypted;

    private String email;

    private String phone;

    private Date startActiveDate;

    private Date endActiveDate;

    private String status;

    private Date lastLoginDate;

    private Date lastPasswordUpdateDate;

    private String frozenFlag;

    private Date frozenDate;

    private String passwordLifespanType;

    private Long passwordLifespanDays;

    private Long passwordLifespanTimes;

    private String description;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordEncrypted() {
        return passwordEncrypted;
    }

    public void setPasswordEncrypted(String passwordEncrypted) {
        this.passwordEncrypted = passwordEncrypted;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getStartActiveDate() {
        return startActiveDate;
    }

    public void setStartActiveDate(Date startActiveDate) {
        this.startActiveDate = startActiveDate;
    }

    public Date getEndActiveDate() {
        return endActiveDate;
    }

    public void setEndActiveDate(Date endActiveDate) {
        this.endActiveDate = endActiveDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Date getLastPasswordUpdateDate() {
        return lastPasswordUpdateDate;
    }

    public void setLastPasswordUpdateDate(Date lastPasswordUpdateDate) {
        this.lastPasswordUpdateDate = lastPasswordUpdateDate;
    }

    public String getFrozenFlag() {
        return frozenFlag;
    }

    public void setFrozenFlag(String frozenFlag) {
        this.frozenFlag = frozenFlag;
    }

    public Date getFrozenDate() {
        return frozenDate;
    }

    public void setFrozenDate(Date frozenDate) {
        this.frozenDate = frozenDate;
    }

    public String getPasswordLifespanType() {
        return passwordLifespanType;
    }

    public void setPasswordLifespanType(String passwordLifespanType) {
        this.passwordLifespanType = passwordLifespanType;
    }

    public Long getPasswordLifespanDays() {
        return passwordLifespanDays;
    }

    public void setPasswordLifespanDays(Long passwordLifespanDays) {
        this.passwordLifespanDays = passwordLifespanDays;
    }

    public Long getPasswordLifespanTimes() {
        return passwordLifespanTimes;
    }

    public void setPasswordLifespanTimes(Long passwordLifespanTimes) {
        this.passwordLifespanTimes = passwordLifespanTimes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}