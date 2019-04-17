package com.codecool.kriger.overcomplicatedtictactoe.controller;

import com.codecool.kriger.overcomplicatedtictactoe.model.Joke;
import com.codecool.kriger.overcomplicatedtictactoe.model.Player;
import com.codecool.kriger.overcomplicatedtictactoe.model.TicTacToeGame;
import com.codecool.kriger.overcomplicatedtictactoe.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"player", "game"})
public class GameController {

    @Autowired
    private JokeService jokeService;

    @ModelAttribute("player")
    public Player getPlayer() {
        return new Player();
    }

    @ModelAttribute("game")
    public TicTacToeGame getGame() {
        return new TicTacToeGame();
    }

    @ModelAttribute("avatar_uri")
    public String getAvatarUri() {
        return "https://robohash.org/codecool";
    }

    @GetMapping(value = "/")
    public String welcomeView(@ModelAttribute Player player) {
        return "welcome";
    }

    @PostMapping(value = "/changeplayerusername")
    public String changPlayerUserName(@ModelAttribute Player player) {
        return "redirect:/game";
    }

    @GetMapping(value = "/game")
    public String gameView(@ModelAttribute("player") Player player, Model model) {

        ResponseEntity<Joke> chuckNorrisJokeResponse = jokeService.getJoke();
        if (chuckNorrisJokeResponse.getStatusCode().equals(HttpStatus.OK)) {
            model.addAttribute("funfact", chuckNorrisJokeResponse.getBody().getValue());
        } else {
            model.addAttribute("funfact", "Chuck Norris found you to laughing on him, and destroyed the server! RUN!");
        }

        model.addAttribute("comic_uri", "http://www.tim-online.nl/blog/wp-content/uploads/2014/07/tv_error.png");

        return "game";
    }

    @GetMapping(value = "/game-move")
    public String gameMove(@ModelAttribute("player") Player player, @ModelAttribute("move") int move) {
        System.out.println("Player moved " + move);
        return "redirect:/game";
    }
}
