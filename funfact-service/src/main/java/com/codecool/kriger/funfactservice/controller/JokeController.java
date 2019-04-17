package com.codecool.kriger.funfactservice.controller;

import com.codecool.kriger.funfactservice.model.Joke;
import com.codecool.kriger.funfactservice.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JokeController {

    @Autowired
    private JokeService jokeService;

    @GetMapping("/")
    public ResponseEntity getJoke() {
        Joke joke = jokeService.getJoke();
        if(joke == null){
            return new ResponseEntity("Sorry, no jokes available now!", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(joke, HttpStatus.OK);

    }

}
