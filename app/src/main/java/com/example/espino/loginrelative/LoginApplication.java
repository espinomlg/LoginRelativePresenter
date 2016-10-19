package com.example.espino.loginrelative;

import android.app.Application;

public class LoginApplication extends Application {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
