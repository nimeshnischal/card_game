package com.nimesh.card_game.service.helper;

import com.nimesh.card_game.entity.Game;
import com.nimesh.card_game.entity.Player;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameHelperTests {

    @Test
    public void testGetMaxDealtCards() {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        game.addPlayer(player1);
        game.addPlayer(player2);
        DealerHelper.dealInitialCards(game);
        int maxDealtCards = GameHelper.getMaxDealtCards(game);
        assertEquals(maxDealtCards, 3);
        DealerHelper.dealCardToPlayer(player1, game.getDealtCardIndexes());
        maxDealtCards = GameHelper.getMaxDealtCards(game);
        assertEquals(maxDealtCards, 4);
        DealerHelper.dealCardToPlayer(player2, game.getDealtCardIndexes());
        maxDealtCards = GameHelper.getMaxDealtCards(game);
        assertEquals(maxDealtCards, 4);
        DealerHelper.dealCardToPlayer(player2, game.getDealtCardIndexes());
        maxDealtCards = GameHelper.getMaxDealtCards(game);
        assertEquals(maxDealtCards, 5);
    }

    @Test
    public void testGetClashedPlayers() {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.addPlayer(player4);
        DealerHelper.dealInitialCards(game);
        DealerHelper.dealCardToPlayer(player1, game.getDealtCardIndexes());
        DealerHelper.dealCardToPlayer(player2, game.getDealtCardIndexes());
        List<Player> clashedPlayers = GameHelper.getClashedPlayers(game);
        assertEquals(clashedPlayers.size(), 2);
        assertTrue(clashedPlayers.contains(player1));
        assertTrue(clashedPlayers.contains(player2));
        DealerHelper.dealCardToPlayer(player3, game.getDealtCardIndexes());
        clashedPlayers = GameHelper.getClashedPlayers(game);
        assertEquals(clashedPlayers.size(), 3);
        assertTrue(clashedPlayers.contains(player3));
    }
}
