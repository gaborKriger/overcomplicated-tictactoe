package com.codecool.kriger.overcomplicatedtictactoe.service;

import com.codecool.kriger.overcomplicatedtictactoe.model.Avatar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AvatarService {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<?> getAvatarUrl(String username){
        String url = "http://localhost:9002/";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Avatar avatar = new Avatar(username);

        HttpEntity<Avatar> entity = new HttpEntity<Avatar>(avatar, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        return response;
    }
}
