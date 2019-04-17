package com.codecool.kriger.comicsservice.service;

import com.codecool.kriger.comicsservice.model.Comics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class ComicsService {

    @Autowired
    private RestTemplate restTemplate;

    private Random myRandom = new Random();

    public int getRandomBetween(int min, int max){
        System.out.println(myRandom.nextInt(min)+max);
        return myRandom.nextInt(min)+min;
    }


    public Comics getComics() {
        try {
            String url = "https://xkcd.com/" + getRandomBetween(1000,1929) + "/info.0.json";
            Comics result = restTemplate.getForObject(url, Comics.class);
            return result;
        } catch (Exception e) {
            return null;
        }
    }

}
