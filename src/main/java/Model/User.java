package Model;

import java.util.*;

public class User {
    private String fullName;
    private final Integer id;
    private final String userName;
    private String password;
    private final List<HistoryActions> actions;
    private final Role role;

    public User(String fullName, Integer id, String userName, String password, Role role) {
        this.fullName = fullName;
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.actions = new ArrayList<>();
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password){this.password = password;}

    public List<HistoryActions> getActions() {
        return Collections.unmodifiableList(this.actions);
    }

    public void setActions(String description) {
        this.actions.add(new HistoryActions(description));
    }

    public Role getRole() {
        return role;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
