package com.devseniorc4.HiguitaR.model;

public class User {
    /*
     TODO: "Add attribute, constructor and getters\setters and implement
      enum class"
    */

    private String fullName;
    private int id;
    private String nickName;
    private String password;
    private Role rol;

    public User(String fullName, int id, String nickName, String password, Role rol) {
        this.fullName = fullName;
        this.id = id;
        this.nickName = nickName;
        this.password = password;
        this.rol = rol;
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

    public void setRol(String oldPassword, Role rol) {
        if (!this.password.equals(oldPassword)){
            System.out.println("Invalid Password! ❌");
            return;
        }
        this.rol = rol;
    }

    public void setPassword(String oldPassword, String newPassword) {
        if (!this.password.equals(oldPassword)){
            System.out.println("Invalid Password! ❌");
            return;
        }
        this.password = newPassword;
    }
}
