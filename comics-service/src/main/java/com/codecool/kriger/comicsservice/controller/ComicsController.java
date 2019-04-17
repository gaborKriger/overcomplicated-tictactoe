package com.codecool.kriger.comicsservice.controller;

import com.codecool.kriger.comicsservice.model.Comics;
import com.codecool.kriger.comicsservice.service.ComicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComicsController {

    @Autowired
    private ComicsService comicsService;

    @GetMapping("/")
    public ResponseEntity getComics() {
        Comics comic = comicsService.getComics();
        if(comic == null){
            return new ResponseEntity(" ", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(comic, HttpStatus.OK);

    }
}
