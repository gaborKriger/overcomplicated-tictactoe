package com.codecool.kriger.funfactservice.service;

import com.codecool.kriger.funfactservice.model.Joke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeService {

    final String url = "https://api.chucknorris.io/jokes/random";

    @Autowired
    private RestTemplate restTemplate;

    public Joke getJoke(){
        try {
            Joke result = restTemplate.getForObject(url, Joke.class);
            return result;
        } catch (Exception e) {
            return null;
        }
    }

}
