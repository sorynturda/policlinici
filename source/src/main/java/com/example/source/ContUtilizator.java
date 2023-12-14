package com.example.source;

public class ContUtilizator {
    private String username;
    private String password;

    public ContUtilizator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "ContUtilizator{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
