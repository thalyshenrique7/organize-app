package com.devthalys.organize.models;

import com.devthalys.organize.interfaces.UserObserver;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserChangeObserver implements UserObserver {

    @Override
    public void onUserChange(UserModel user) {
        System.out.println("User Observer - User changed: " + user.getName() + "\n" + user.getCpf() + "\n" + LocalDateTime.now());
    }
}
