package com.mxml;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "User")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "userId",
        "userName",
        "password",
        "birthday",
        "money",
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    // 用户Id
    private int userId;
    // 用户名
    @XmlElement(name = "user_name")
    @XmlJavaTypeAdapter(CDATATypeAdapter.class)
    private String userName;
    // 用户密码
    @NonNull
    private String password;
    // 用户生日
    @NonNull
    private Date birthday;
    // 用户钱包
    private double money;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User [birthday=" + birthday + ", money=" + money
                + ", password=" + password + ", userId=" + userId
                + ", userName=" + userName + "]";
    }

}
