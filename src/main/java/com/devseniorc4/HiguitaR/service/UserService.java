package com.devseniorc4.HiguitaR.service;

import com.devseniorc4.HiguitaR.model.User;
import com.devseniorc4.HiguitaR.model.Role;
import com.devseniorc4.HiguitaR.model.HistoryAction;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> userList = new ArrayList<>();
    public void createUser (String fullName, int id,  String nickName,
                            String password,
                            Role rol,
                            HistoryAction action) {
        if (!adminValid){
            System.out.println("Admin-only access ❌");
            return;
        }
        User user = new User(fullName, id,nickName, password, rol);
        userList.add(user);
        System.out.println("User created successful ✅");
    }

    public void findUser (int id){
        if (!adminValid){
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
