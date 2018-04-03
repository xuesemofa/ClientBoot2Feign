package org.client.com.server.model;

import java.io.Serializable;

public class TokenModel implements Serializable {
    private String uuid;
    private String account;
    private String token;
    //    过期时间
    private long endTimes;
    //    是否已经使用，token只能使用一次
    private String isUse;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getEndTimes() {
        return endTimes;
    }

    public void setEndTimes(long endTimes) {
        this.endTimes = endTimes;
    }

    public String getIsUse() {
        return isUse;
    }

    public void setIsUse(String isUse) {
        this.isUse = isUse;
    }

    public TokenModel() {
        super();
    }

    public TokenModel(String uuid, String account, String token, long endTimes, String isUse) {
        this.uuid = uuid;
        this.account = account;
        this.token = token;
        this.endTimes = endTimes;
        this.isUse = isUse;
    }

    @Override
    public String toString() {
        return "TokenModel{" +
                "uuid='" + uuid + '\'' +
                ", account='" + account + '\'' +
                ", token='" + token + '\'' +
                ", endTimes=" + endTimes +
                ", isUse='" + isUse + '\'' +
                '}';
    }
}
