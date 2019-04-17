package com.codecool.kriger.avatarservice.controller;

import com.codecool.kriger.avatarservice.model.Avatar;
import com.codecool.kriger.avatarservice.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AvatarController {

    @Autowired
    private AvatarService avatarService;

    @PostMapping("/")
    public ResponseEntity getUsername(@RequestBody Avatar avatar) {
        String avatarUrl = avatarService.getAvatarUrl(avatar.getUsername());
        return new ResponseEntity(avatarUrl, HttpStatus.OK);
    }
}
