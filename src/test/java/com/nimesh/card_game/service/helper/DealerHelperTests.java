package com.nimesh.card_game.service.helper;

import com.nimesh.card_game.entity.Game;
import com.nimesh.card_game.entity.Player;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DealerHelperTests {

    @Test
    public void testDealCards() {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        game.addPlayer(player1);
        game.addPlayer(player2);
        DealerHelper.dealInitialCards(game);
        assertEquals(game.getPlayers().get(0).getDealtCards().size(), 3);
        assertEquals(game.getPlayers().get(1).getDealtCards().size(), 3);
    }

    @Test
    public void testDealCardToPlayer() {
        Player player = new Player();
        List<Integer> dealtCardsIndexes = new ArrayList<>();
        DealerHelper.dealCardToPlayer(player, dealtCardsIndexes);
        assertEquals(player.getDealtCards().size(), 1);
        DealerHelper.dealCardToPlayer(player, dealtCardsIndexes);
        assertEquals(player.getDealtCards().size(), 2);
    }

    @Test
    public void testDealCardWithIndexNotIn() {
        List<Integer> dealtCardsIndexes = new ArrayList<>();
        for (int i = 0; i < 52; ++i)
            dealtCardsIndexes.add(DealerHelper.dealCardWithIndexNotIn(dealtCardsIndexes));
        assertEquals(new HashSet<>(dealtCardsIndexes).size(), 52);
    }

    @Test
    public void testCardIndexToCardValue() {
        int cardIndex = 0;
        String cardValue = DealerHelper.cardIndexToCardValue(cardIndex);
        assertEquals(cardValue, "A");
        cardIndex = 26;
        cardValue = DealerHelper.cardIndexToCardValue(cardIndex);
        assertEquals(cardValue, "A");
        cardIndex = 51;
        cardValue = DealerHelper.cardIndexToCardValue(cardIndex);
        assertEquals(cardValue, "K");
        cardIndex = 11;
        cardValue = DealerHelper.cardIndexToCardValue(cardIndex);
        assertEquals(cardValue, "Q");
        cardIndex = 23;
        cardValue = DealerHelper.cardIndexToCardValue(cardIndex);
        assertEquals(cardValue, "J");
        cardIndex = 35;
        cardValue = DealerHelper.cardIndexToCardValue(cardIndex);
        assertEquals(cardValue, "10");
        cardIndex = 40;
        cardValue = DealerHelper.cardIndexToCardValue(cardIndex);
        assertEquals(cardValue, "2");
    }
}
