package com.company;

public class User {
    private final String nickname;
    private final String password;

    public User(String nick, String pass) {
        this.nickname = nick;
        this.password = pass;
    }

    public boolean Correct_password(String givenPassword) {
        return givenPassword.equals(this.password);
    }
}
