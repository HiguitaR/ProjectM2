package Service;

import Model.Role;
import Model.User;

import java.util.ArrayList;
import java.util.List;


public class UserService implements serviceImplement{

    private final List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
        users.add(new User("Juan Higuita", 1, "admin",
                "admin123", Role.ADMIN));
    }

    @Override
    public User logging(String userName, String userPassword) {
        if(userName.isBlank())return null;
        if(userPassword.isBlank())return null;
        for(User user : users) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(userPassword)) {
                user.setActions("App logging!");
                return user;
            }
        }
        return null;
    }

    @Override
    public void showHistory(User currentUser) {
        if(currentUser != null) {
            System.out.println("===History Actions===");
            for(var action : currentUser.getActions()){
                System.out.println(action);
            }
        }else {
            System.out.println("There not have history to show!");
        }
    }

    @Override
    public Boolean createUser(User currentUser, String fullName, Integer id,
                              String userName, String password, Role role) {

        if(!currentUser.getRole().equals(Role.ADMIN))return false;
        if(fullName.isBlank())return false;
        if(id < 0)return false;
        if(userName.isBlank())return false;
        if(password.isBlank())return false;
        if(role == null)return false;
        users.add(new User(fullName, id, userName, password, role));
        currentUser.setActions("Created a new user!");
        return true;
    }

    @Override
    public Boolean updateUserName(User currentUser, String newfullName,
                                  Integer userId) {

        if(!currentUser.getRole().equals(Role.ADMIN))return false;
        if(newfullName.isBlank())return false;
        if(userId < 0)return false;
        var checkUser = findById(userId);
        if(checkUser == null)return false;
        checkUser.setFullName(newfullName);
        currentUser.setActions("Updated user name! " + checkUser.getUserName());
        return true;
    }

    @Override
    public Boolean updateUserPassword(User currentUser, String newPassword,
                                      Integer userId) {
        if(!currentUser.getRole().equals(Role.ADMIN))return false;
        if(newPassword.isBlank())return false;
        if(userId < 0)return false;
        var checkUser = findById(userId);
        if(checkUser == null)return false;
        checkUser.setPassword(newPassword);
        currentUser.setActions("Updated user password " + checkUser.getUserName());
        return true;
    }

    @Override
    public Boolean deleteUser(User currentUser, String userName) {

        if(!currentUser.getRole().equals(Role.ADMIN))return false;
        if(userName.isBlank())return false;
        var deleteUser = findByName(userName);
        if(deleteUser == null)return false;
        users.remove(deleteUser);
        currentUser.setActions("Delete a user " + deleteUser.getUserName());
        return true;
    }


    private User findById(Integer userId) {
        if(userId < 0)return null;
        for(User user : users){
            if(user.getId().equals(userId)){
                return user;
            }
        }
        return null;
    }

    private User findByName(String userName) {
        if(userName.isBlank())return null;
        for(User user : users){
            if(user.getUserName().equals(userName)){
                return user;
            }
        }
        return null;
    }

    @Override
    public Boolean updateName(User currentUser, String password, String newName) {
        if(currentUser == null)return false;
        if(!currentUser.getPassword().equals(password))return false;
        if(newName.isBlank())return false;
        currentUser.setFullName(newName);
        currentUser.setActions("Update my name!");
        return true;
    }

    @Override
    public Boolean updatePassword(User currentUser, String oldPassword,
                                  String newPassword) {
        if(currentUser == null)return false;
        if(oldPassword.isBlank())return false;
        if(newPassword.isBlank())return false;
        if(!currentUser.getPassword().equals(oldPassword))return false;
        currentUser.setPassword(newPassword);
        currentUser.setActions("Update my password!");
        return true;
    }
}
