package com.devseniorc4.HiguitaR.model;

import java.util.ArrayList;
import java.util.List;

public class User {


    private String fullName;
    private int id;
    private String nickName;
    private String password;
    private Role rol;
    private List<HistoryAction> action;

    public User(String fullName, int id, String nickName, String password, Role rol) {
        this.fullName = fullName;
        this.id = id;
        this.nickName = nickName;
        this.password = password;
        this.rol = rol;
        this.action = new ArrayList<>();

    }

    public String getFullName() {
        return fullName;
    }

    public int getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPassword() {
        return password;
    }

    public Role getRol() {
        return rol;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setRol(Role rol) {
        this.rol = rol;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void setAction(HistoryAction action) {
        this.action.add(action);
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", id=" + id +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", rol=" + rol +
                '}';
    }
}
