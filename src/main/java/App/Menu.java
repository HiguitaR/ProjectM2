package App;

import Model.Role;
import Service.UserService;
import Service.serviceImplement;

import java.util.Scanner;

public class Menu {
    private final serviceImplement service;
    private final Scanner sc;
    private String option;

    public Menu() {
        this.service = new UserService();
        sc = new Scanner(System.in);
    }

    public void Start(){
        System.out.println("Welcome to management costumers");
        do {
            mainMenu();
            System.out.println("Enter a valid option: ");
            option = sc.next();
            sc.nextLine();
            switch (option) {
                case "1":
                    validateUser();
                    break;
                case "0":
                    System.out.println("Closing system.....");
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }while (!option.equals("0"));

    }

    private void mainMenu(){
        System.out.println("=== LOGIN ===");
        System.out.println("1. Login");
        System.out.println("0. Exit");
    }

    private void adminMenu(){
        System.out.println("=== ADMIN MENU ===");
        System.out.println("1. Create a new user");
        System.out.println("2. Update a user name");
        System.out.println("3. Update a user password");
        System.out.println("4. Delete a user");
        System.out.println("5. Show History actions");
        System.out.println("6. Back Menu");
        System.out.println("0. Exit");
    }

    private void userMenu(){
        System.out.println("=== USER MENU ===");
        System.out.println("1. Update my name");
        System.out.println("2. Update my password");
        System.out.println("3. Show my history actions");
        System.out.println("4. Back Menu");
        System.out.println("0. Exit");
    }

    private void validateUser(){
        System.out.println("===Login App===");
        System.out.println("Enter a valid user name: ");
        var name = sc.next();
        sc.nextLine();
        System.out.println("Enter a valid password: ");
        var password = sc.next();
        sc.nextLine();
        var currentUser = service.logging(name, password);
        if(currentUser == null){
            System.out.println("Login fail! invalid user name or password");
            validateUser();
        }
        if(currentUser.getRole().equals(Role.ADMIN)){
            System.out.println("Welcome Admin " + currentUser.getFullName());
            do{
                adminMenu();
                System.out.println("Enter a valid option");
                option = sc.next();
                sc.nextLine();
                switch (option){
                    case "1":
                        System.out.println("Enter a valid full name: ");
                        var fullName = sc.next();
                        sc.nextLine();
                        System.out.println("Enter a valid id: ");
                        var id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter a valid user name: ");
                        var userName = sc.next();
                        sc.nextLine();
                        System.out.println("Enter a valid password: ");
                        var otherPassword = sc.next();
                        sc.nextLine();
                        System.out.println("Enter a valid role: ");
                        var role = sc.next();
                        sc.nextLine();
                        Role newrole = (role.equals("admin"))? Role.ADMIN : Role.USER;
                        if(service.createUser(currentUser, fullName, id, userName,
                                otherPassword, newrole)){
                            System.out.println("User created successful! ");
                        }else{
                            System.out.println("Something is wrong!");
                        }
                        break;
                    case "2":
                        System.out.println("Enter a new full name: ");
                        var newName = sc.next();
                        sc.nextLine();
                        System.out.println("Enter a user id: ");
                        var userId = sc.nextInt();
                        sc.nextLine();
                        if(service.updateUserName(currentUser, newName, userId)){
                            System.out.println("User name update successful");
                        }else{
                            System.out.println("Something is wrong!");
                        }
                        break;
                    case "3":
                        System.out.println("Enter a user id: ");
                        userId = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter a new user password");
                        password = sc.next();
                        sc.nextLine();
                        if(service.updateUserPassword(currentUser, password,
                                userId)){
                            System.out.println("User password update successful!");
                        }else{
                            System.out.println("Something is wrong!");
                        }
                        break;
                    case "4":
                        System.out.println("Enter a user name: ");
                        userName = sc.next();
                        sc.nextLine();
                        if(service.deleteUser(currentUser, userName)){
                            System.out.println("User delete successful!");
                        }else{
                            System.out.println("Something is wrong!");
                        }
                        break;
                    case "5":
                        service.showHistory(currentUser);
                        break;
                    case "6":
                        validateUser();
                        break;
                    case "0":
                        System.out.println("Logging out...");
                        break;
                    default:
                        System.out.println("Invalid option!");
                        break;
                }
            }while (!option.equals("0"));
        }else{
            System.out.println("Welcome " + currentUser.getFullName());
            do {
                userMenu();
                System.out.println("Enter a valid option: ");
                option = sc.next();
                sc.nextLine();

                switch (option) {
                    case "1":
                        System.out.println("Confirm your password: ");
                        var passForName = sc.next();
                        sc.nextLine();
                        System.out.println("Enter your new full name: ");
                        var newFullName = sc.next();
                        sc.nextLine();

                        if (service.updateName(currentUser, passForName, newFullName)) {
                            System.out.println("Name updated successfully!");
                        } else {
                            System.out.println("Failed to update name. Check password.");
                        }
                        break;
                    case "2":
                        System.out.println("Enter your old password: ");
                        var oldPass = sc.next();
                        sc.nextLine();
                        System.out.println("Enter your new password: ");
                        var newPass = sc.next();
                        sc.nextLine();

                        if (service.updatePassword(currentUser, oldPass, newPass)) {
                            System.out.println("Password updated successfully!");
                        } else {
                            System.out.println("Failed to update password. Check old password.");
                        }
                        break;

                    case "3":
                        service.showHistory(currentUser);
                        break;

                    case "4":
                        validateUser();
                        break;
                    case "0":
                        System.out.println("Logging out...");
                        break;
                    default:
                        System.out.println("Invalid option!");
                        break;
                    }
                } while (!option.equals("0"));
        }

    }
}
