package org.client.com.server.model;

import java.io.Serializable;

/**
 * @name 账户资料
 * @table account_table
 */
public class AccountModel implements Serializable {
    //    主键
    private String uuid;
    //    账号
    private String account;
    //    密码
    private String password;
    //    账号类型
//    1:客户  2：客户升级为商家  3：后台用户 -1:超级管理员
    private int acctype = 1;
    //    来源
    private String source = "pc平台注册";
    //    第三方授权
    private String authorization;
    //    时间
    private long times;
    //    客户级别
//   级别越低数字越小
    private String level = "0";

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAcctype() {
        return acctype;
    }

    public void setAcctype(int acctype) {
        this.acctype = acctype;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public long getTimes() {
        return times;
    }

    public void setTimes(long times) {
        this.times = times;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public AccountModel() {
        super();
    }

    public AccountModel(String uuid, String account, String password, int acctype, String source, String authorization, long times, String level) {
        this.uuid = uuid;
        this.account = account;
        this.password = password;
        this.acctype = acctype;
        this.source = source;
        this.authorization = authorization;
        this.times = times;
        this.level = level;
    }

    @Override
    public String toString() {
        return "AccountModel{" +
                "uuid='" + uuid + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", acctype=" + acctype +
                ", source='" + source + '\'' +
                ", authorization='" + authorization + '\'' +
                ", times=" + times +
                ", level='" + level + '\'' +
                '}';
    }
}