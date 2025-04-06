package com.suyog.SpringBootRest.models.DTO;

import com.suyog.SpringBootRest.models.Role;
import com.suyog.SpringBootRest.models.authentication_models.User;

public class UserDTO {

    private String fullName;
    private String userName;
    private String email;
    private String password;
    private Role role;

    public User userBuilder() {
        User user = new User();

        user.setUserName(this.getUserName());
        user.setEmail(this.getEmail());
        user.setPassword(this.getPassword());
        user.setRole(this.getRole());
        user.setFullName(this.getFullName());

        return user;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
