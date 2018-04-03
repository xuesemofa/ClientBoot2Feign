package org.client.com.server.model;

import java.io.Serializable;

/**
 * @author ld
 * @name 个人资料
 * @table
 * @remarks
 */
public class PersonalDataModel implements Serializable {

    //    uuid
    private String uuid;
    //    账户
    private String account;
    //    头像
    private String portrait;
    //    昵称
    private String nickname;
    //    姓
    private String surname;
    //    名
    private String name;
    //    手机
    private String phone;
    //    身份证号
    private String idno;
    //    性别 Y:男 N:女
    private String sex;
    //    地址
    private String address;
    //    qq
    private String qq;
    //    微信
    private String wechat;
    //    微博
    private String microblog;

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

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getMicroblog() {
        return microblog;
    }

    public void setMicroblog(String microblog) {
        this.microblog = microblog;
    }

    public PersonalDataModel() {
        super();
    }

    public PersonalDataModel(String uuid,
                             String account,
                             String portrait,
                             String nickname,
                             String surname,
                             String name,
                             String phone,
                             String idno,
                             String sex,
                             String address,
                             String qq,
                             String wechat,
                             String microblog) {
        this.uuid = uuid;
        this.account = account;
        this.portrait = portrait;
        this.nickname = nickname;
        this.surname = surname;
        this.name = name;
        this.phone = phone;
        this.idno = idno;
        this.sex = sex;
        this.address = address;
        this.qq = qq;
        this.wechat = wechat;
        this.microblog = microblog;
    }

    @Override
    public String toString() {
        return "PersonalDataModel{" +
                "uuid='" + uuid + '\'' +
                ", account='" + account + '\'' +
                ", portrait='" + portrait + '\'' +
                ", nickname='" + nickname + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", idno='" + idno + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", qq='" + qq + '\'' +
                ", wechat='" + wechat + '\'' +
                ", microblog='" + microblog + '\'' +
                '}';
    }
}
