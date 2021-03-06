package com.nimesh.card_game.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Game {
    private List<Player> players;
    private Integer winnerPlayerIndex;
    @JsonIgnore
    private List<Integer> dealtCardIndexes;

    public Game() {
        players = new ArrayList<>();
        dealtCardIndexes = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void declareWinner(Player player) {
        winnerPlayerIndex = players.indexOf(player);
    }
}
