package com.example.elm.entity;

import com.example.elm.util.Base64Util;
import jakarta.persistence.*;

@Entity
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userSex;

    @Column(columnDefinition = "TEXT")
    private String userImg;

    @Column(nullable = false)
    private Boolean delTag = false;

    // Getters and Setters

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public void setUserImgEncoded(String userImg) {
        this.userImg = Base64Util.encode(userImg);
    }

    public String getUserImgDecoded() {
        return Base64Util.decode(this.userImg);
    }

    public Boolean getDelTag() {
        return delTag;
    }

    public void setDelTag(Boolean delTag) {
        this.delTag = delTag;
    }
}