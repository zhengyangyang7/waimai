package com.veliona.elemebackend.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@TableName("user")
public class User {
    @TableId(value = "userID")
    private String userID;

    @TableField(select = false)
    private String userAccount;
    private String userPassword;
    private String userName;
    private String userAvatar;
    private Boolean userStatus; //true for exist


    public String toString() {
        return "User{" +
                "userId='" + userID + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userAvatar='" + userAvatar + '\'' +
                ", userStatus=" + userStatus +
                '}';
    }
}
