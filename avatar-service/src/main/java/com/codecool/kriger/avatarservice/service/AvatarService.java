package com.codecool.kriger.avatarservice.service;

import com.codecool.kriger.avatarservice.model.Avatar;
import org.springframework.stereotype.Service;

@Service
public class AvatarService {

    public String getAvatarUrl(Avatar avatar) {
        String userName = avatar.getUsername();
        System.out.println(userName);
        String url = "https://robohash.org/" + userName;
        return url;
    }
}
