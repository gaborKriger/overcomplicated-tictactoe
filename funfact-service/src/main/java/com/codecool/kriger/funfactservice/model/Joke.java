package com.codecool.kriger.funfactservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Joke {

    private String category;
    private String iconUrl;
    private String id;
    private String url;
    private String value;


}
