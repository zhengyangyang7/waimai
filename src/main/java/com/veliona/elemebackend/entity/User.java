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
    @TableId("userID")
    private String userID;

    @TableField("userAccount")
    private String userAccount;
    @TableField("userPassword")
    private String userPassword;
    @TableField("userName")
    private String userName;
    @TableField("userAvatar")
    private String userAvatar;
    @TableField("userStatus")
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
