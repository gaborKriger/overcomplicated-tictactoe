package com.codecool.kriger.overcomplicatedtictactoe.service;

import com.codecool.kriger.overcomplicatedtictactoe.model.Comics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.GET;

@Service
public class ComicsService {

    @Autowired
    private RestTemplate restTemplate;


    public ResponseEntity<Comics> getComic(){
        return restTemplate.exchange("http://localhost:9001/", GET, null, Comics.class);

    }

}
