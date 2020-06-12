package com.nimesh.card_game.service;

import com.nimesh.card_game.entity.Game;
import com.nimesh.card_game.config.AppConstants;
import com.nimesh.card_game.entity.Player;
import com.nimesh.card_game.service.helper.DealerHelper;
import com.nimesh.card_game.service.helper.GameHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GameService {

    public Game newGame() {
        Game game = new Game();
        game.setPlayers(new ArrayList<>());
        for (int playerNumber = 1; playerNumber <= AppConstants.MAX_PLAYERS; ++playerNumber) {
            Player player = new Player();
            game.addPlayer(player);
        }
        DealerHelper.dealInitialCards(game);
        GameHelper.simulateGame(game);
        return game;
    }
}
