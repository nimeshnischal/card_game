package com.nimesh.card_game.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Player {
    private List<String> dealtCards;
    // TODO: write test case to check serialized json doesnt have this
    // https://www.baeldung.com/jackson-field-serializable-deserializable-or-not
    // TODO: check if we can remove this
    @JsonIgnore
    private List<Integer> dealtCardsIndexes;
    @JsonIgnore
    private Integer score;

    public Player() {
        dealtCards = new ArrayList<>();
        dealtCardsIndexes = new ArrayList<>();
    }
}
