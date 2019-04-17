package com.codecool.kriger.avatarservice.service;

import com.codecool.kriger.avatarservice.model.Avatar;
import org.springframework.stereotype.Service;

@Service
public class AvatarService {

    public String getAvatarUrl(String username) {
        Avatar avatar = new Avatar(username);
        String userName = avatar.getUsername();
        String url = "https://robohash.org/" + userName;
        return url;
    }
}
