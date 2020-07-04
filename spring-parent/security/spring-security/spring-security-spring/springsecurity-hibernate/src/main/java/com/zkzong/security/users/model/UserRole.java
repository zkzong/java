package com.zkzong.security.users.model;

public class UserRole {

    private Integer userRoleId;
    private Users user;
    private String role;

    public UserRole() {
    }

    public UserRole(Users user, String role) {
        this.user = user;
        this.role = role;
    }

    public Integer getUserRoleId() {
        return this.userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Users getUser() {
        return this.user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
