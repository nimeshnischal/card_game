package com.nimesh.card_game.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Player {
    private List<String> dealtCards;
    @JsonIgnore
    private Integer score;
    public Player() {
        dealtCards = new ArrayList<>();
    }
}
