package com.codecool.kriger.overcomplicatedtictactoe.service;

import com.codecool.kriger.overcomplicatedtictactoe.model.Joke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.GET;

@Service
public class JokeService {

    @Autowired
    private RestTemplate restTemplate;


    public ResponseEntity<Joke> getJoke(){
        return restTemplate.exchange("http://localhost:9000/", GET, null, Joke.class);

    }

}
