package com.nimesh.card_game.service.helper;

import com.nimesh.card_game.entity.Game;
import com.nimesh.card_game.config.AppConstants;
import com.nimesh.card_game.entity.Player;

import java.util.List;
import java.util.Random;

public class DealerHelper {

    private final static Random random = new Random();

    public static void dealInitialCards(Game game) {
        for (int dealingRound = 0; dealingRound < 3; ++dealingRound) {
            for (int playerNumber = 1; playerNumber <= game.getPlayers().size(); ++playerNumber) {
                dealCardToPlayer(game.getPlayers().get(playerNumber -1), game.getDealtCardIndexes());
            }
        }
    }

    static void dealCardToPlayer(Player player, List<Integer> dealtCardsIndexes) {
        int dealtCardIndex = dealCardWithIndexNotIn(dealtCardsIndexes);
        dealtCardsIndexes.add(dealtCardIndex);
        player.getDealtCards().add(cardIndexToCardValue(dealtCardIndex));
    }

    static int dealCardWithIndexNotIn(List<Integer> dealtCardsIndexes) {
        int dealtCard = random.nextInt(52);
        while (dealtCardsIndexes.contains(dealtCard))
            dealtCard = random.nextInt(52);
        return dealtCard;
    }

    static String cardIndexToCardValue(int cardIndex) {
        String cardValue;
        int cardIndexInSuit = cardIndex % 13;
        switch (cardIndexInSuit) {
            case 0:
                cardValue = "A";
                break;
            case 10:
                cardValue = "J";
                break;
            case 11:
                cardValue = "Q";
                break;
            case 12:
                cardValue = "K";
                break;
            default:
                cardValue = String.valueOf(cardIndexInSuit + 1);
        }
        return cardValue;
    }

}
