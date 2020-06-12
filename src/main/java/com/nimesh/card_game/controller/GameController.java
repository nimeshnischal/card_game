package com.nimesh.card_game.controller;

import com.nimesh.card_game.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ResponseEntity newGame() {
        return new ResponseEntity<>(gameService.newGame(), HttpStatus.CREATED);
    }
}
