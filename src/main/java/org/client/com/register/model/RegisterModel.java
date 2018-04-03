package org.client.com.register.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class RegisterModel implements Serializable {

    private String uuid;

    @NotBlank(message = "账户不能为空")
    @Email(message = "账户不是标准的email格式")
    private String account;

    @NotBlank(message = "密码不能为空")
    @Pattern(regexp = "[a-zA-Z0-9]*", message = "密码由数字和英文字母组成,必须含有大小写")
    @Size(min = 8, max = 16, message = "密码长度为8-16之间")
    private String password;

    @NotBlank(message = "第二次密码不能为空")
    @Pattern(regexp = "[a-zA-Z0-9]*", message = "密码由数字和英文字母组成,必须含有大小写")
    @Size(min = 8, max = 16, message = "密码长度为8-16之间")
    private String password2;

    private String yzm;

    private boolean pass;

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

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getYzm() {
        return yzm;
    }

    public void setYzm(String yzm) {
        this.yzm = yzm;
    }

    public boolean isPass() {
        return password.equals(password2);
    }

    public RegisterModel() {
        super();
    }

    public RegisterModel(String uuid, String account, String password, String password2, String yzm, boolean pass) {
        this.uuid = uuid;
        this.account = account;
        this.password = password;
        this.password2 = password2;
        this.yzm = yzm;
        this.pass = pass;
    }
}
