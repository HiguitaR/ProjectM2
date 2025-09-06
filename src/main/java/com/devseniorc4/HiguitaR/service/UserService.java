package com.devseniorc4.HiguitaR.service;

import com.devseniorc4.HiguitaR.model.User;
import com.devseniorc4.HiguitaR.model.Role;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> userList = new ArrayList<>();
    private User currentUser;

    public void loginUser(String nickName, String password){
        for (User user : userList){
            if (user.getNickName().equals(nickName) && user.getPassword().equals(password)
                    && isAdmin()){
                this.currentUser = user;
                System.out.println("Login successful! ✅, welcome " + user.getFullName());
                user.setAction("User logged in!");
                return;
            }
        }
        System.out.println("User nickname or password invalid ❌");
    }

    public Boolean isAdmin(){
        return currentUser != null && currentUser.getRol() == Role.ADMIN;
    }

    public void createUser (String fullName, int id,  String nickName,
                            String password,
                            Role rol) {
        if (!isAdmin()){
            System.out.println("Admin-only access ❌");
            return;
        }
        User user = new User(fullName, id,nickName, password, rol);
        userList.add(user);
        System.out.println("User created successful ✅");
    }

    public void findUser (int id){
        if (!isAdmin()){
            System.out.println("Admin-only access ❌");
            return;
        }
        for (User user : userList){
            if (user.getId() == id){
                System.out.println(user);
            }
        }
    }
}
