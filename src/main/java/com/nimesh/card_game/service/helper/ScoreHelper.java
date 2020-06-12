package com.nimesh.card_game.service.helper;

import com.nimesh.card_game.config.AppConstants;
import com.nimesh.card_game.entity.Player;

import java.util.*;

class ScoreHelper {

    static void calculateScoresOfPlayers(List<Player> players) {
        for (Player player: players) {
            List<String> dealtCards = player.getDealtCards();
            if (dealtCards.size() > 3)
                player.setScore(player.getScore() + getLastDealtCardScore(dealtCards));
            else if (isDealtCardsTriplet(dealtCards))
                player.setScore(calculateTripletScore(dealtCards));
            else if (isDealtCardsInSequence(dealtCards))
                player.setScore(calculateSequenceScore(dealtCards));
            else if (isDealtCardsPair(dealtCards))
                player.setScore(calculatePairScore(dealtCards));
            else
                player.setScore(calculateTopCardScore(dealtCards));
        }
    }

    static List<Player> getPlayersWithHighestScore(List<Player> players) {
        int highestScore = 0;
        List<Player> playersWithHighestScore = new ArrayList<>();
        for (Player player: players) {
            if (player.getScore() > highestScore) {
                highestScore = player.getScore();
                playersWithHighestScore = new ArrayList<>(Collections.singletonList(player));
            } else if (player.getScore() == highestScore) {
                playersWithHighestScore.add(player);
            }
        }
        return playersWithHighestScore;
    }

    static int getLastDealtCardScore(List<String> dealtCards) {
        return getCardValue(dealtCards.get(dealtCards.size()-1));
    }

    static boolean isDealtCardsTriplet(List<String> dealtCards) {
        boolean isTriplet = true;
        if (dealtCards.size() != 3)
            isTriplet = false;
        if (new HashSet<>(dealtCards).size() != 1)
            isTriplet = false;
        return isTriplet;
    }

    static boolean isDealtCardsInSequence(List<String> dealtCards) {
        boolean isSequence = true;
        if (dealtCards.size() != 3)
            isSequence = false;
        if (new HashSet<>(dealtCards).size() != 3)
            isSequence = false;
        int sumValue = calculateSequenceScore(dealtCards) - AppConstants.SEQUENCE_BASE_SCORE;
        if (sumValue % 3 != 0)
            isSequence = false;
        int meanValueOfDealtCards = sumValue/3;
        if (!dealtCards.contains(getCardFromCardValue(meanValueOfDealtCards)) ||
                !dealtCards.contains(getCardFromCardValue(meanValueOfDealtCards + 1)))
            isSequence = false;
        return isSequence;
    }

    static boolean isDealtCardsPair(List<String> dealtCards) {
        boolean isPair = true;
        if (dealtCards.size() != 3)
            isPair = false;
        if (new HashSet<>(dealtCards).size() != 2)
            isPair = false;
        return isPair;
    }

    static int calculateTripletScore(List<String> dealtCards) {
        return AppConstants.TRIPLET_BASE_SCORE + 3 * getCardValue(dealtCards.get(0));
    }

    static int calculateSequenceScore(List<String> dealtCards) {
        int cardsSumScore = calculateSumOfCardValues(dealtCards);
        // Handling case of '32A'
        if (cardsSumScore == 19 && dealtCards.contains("A"))
            cardsSumScore -= 13;
        return AppConstants.SEQUENCE_BASE_SCORE + cardsSumScore;
    }

    static int calculatePairScore(List<String> dealtCards) {
        int cardsSumScore = 0;
        for (String dealtCard: new HashSet<>(dealtCards))
            if (Collections.frequency(dealtCards, dealtCard) == 2)
                cardsSumScore = 2 * getCardValue(dealtCard);
        return AppConstants.PAIR_BASE_SCORE + cardsSumScore;
    }

    static int calculateTopCardScore(List<String> dealtCards) {
        String topCard = dealtCards.stream()
                .max(Comparator.comparing(ScoreHelper::getCardValue)).orElseThrow(RuntimeException::new);
        return AppConstants.TOP_CARD_BASE_SCORE + getCardValue(topCard);
    }

    static int calculateSumOfCardValues(List<String> dealtCards) {
        int sumScore = 0;
        for (String dealtCard: dealtCards)
            sumScore += getCardValue(dealtCard);
        return sumScore;
    }

    static int getCardValue(String dealtCard) {
        int score;
        switch (dealtCard) {
            case "A": score = 14; break;
            case "K": score = 13; break;
            case "Q": score = 12; break;
            case "J": score = 11; break;
            default: score = Integer.parseInt(dealtCard);
        }
        return score;
    }

    static String getCardFromCardValue(int value) {
        String dealtCard;
        switch (value) {
            case 14:
            case 1: dealtCard = "A"; break;
            case 13: dealtCard = "K"; break;
            case 12: dealtCard = "Q"; break;
            case 11: dealtCard = "J"; break;
            default: dealtCard = String.valueOf(value);
        }
        return dealtCard;
    }
}
