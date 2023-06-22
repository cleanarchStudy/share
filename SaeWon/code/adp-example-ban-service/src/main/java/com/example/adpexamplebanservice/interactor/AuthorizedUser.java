package com.example.adpexamplebanservice.interactor;

import com.example.adpexamplebanservice.entity.User;

import java.util.List;

public record AuthorizedUser(String userId, List<String> roles) {

    public static AuthorizedUser from(User user) {
        return new AuthorizedUser(user.getEmail(), user.getRoles());
    }
}
