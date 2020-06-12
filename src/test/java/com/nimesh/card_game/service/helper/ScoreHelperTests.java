package com.nimesh.card_game.service.helper;

import com.nimesh.card_game.config.AppConstants;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ScoreHelperTests {

    @Test
    public void testIsDealtCardsTriplet() {
        List<String> dealtCards = Arrays.asList("2", "2", "2");
        boolean isTriplet = ScoreHelper.isDealtCardsTriplet(dealtCards);
        assertTrue(isTriplet);
        dealtCards = Arrays.asList("2", "3", "A");
        isTriplet = ScoreHelper.isDealtCardsTriplet(dealtCards);
        assertFalse(isTriplet);
        dealtCards = Arrays.asList("A", "A", "A");
        isTriplet = ScoreHelper.isDealtCardsTriplet(dealtCards);
        assertTrue(isTriplet);
        dealtCards = Arrays.asList("10", "10", "10");
        isTriplet = ScoreHelper.isDealtCardsTriplet(dealtCards);
        assertTrue(isTriplet);
        dealtCards = Arrays.asList("5", "5", "5");
        isTriplet = ScoreHelper.isDealtCardsTriplet(dealtCards);
        assertTrue(isTriplet);
        dealtCards = Arrays.asList("J", "J", "J");
        isTriplet = ScoreHelper.isDealtCardsTriplet(dealtCards);
        assertTrue(isTriplet);
        dealtCards = Arrays.asList("K", "Q", "J");
        isTriplet = ScoreHelper.isDealtCardsTriplet(dealtCards);
        assertFalse(isTriplet);
    }

    @Test
    public void testIsDealtCardsSequence() {
        List<String> dealtCards = Arrays.asList("2", "3", "4");
        boolean isSequence = ScoreHelper.isDealtCardsInSequence(dealtCards);
        assertTrue(isSequence);
        dealtCards = Arrays.asList("2", "3", "A");
        isSequence = ScoreHelper.isDealtCardsInSequence(dealtCards);
        assertTrue(isSequence);
        dealtCards = Arrays.asList("K", "Q", "J");
        isSequence = ScoreHelper.isDealtCardsInSequence(dealtCards);
        assertTrue(isSequence);
        dealtCards = Arrays.asList("Q", "A", "K");
        isSequence = ScoreHelper.isDealtCardsInSequence(dealtCards);
        assertTrue(isSequence);
        dealtCards = Arrays.asList("2", "5", "7");
        isSequence = ScoreHelper.isDealtCardsInSequence(dealtCards);
        assertFalse(isSequence);
        dealtCards = Arrays.asList("A", "K", "2");
        isSequence = ScoreHelper.isDealtCardsInSequence(dealtCards);
        assertFalse(isSequence);
        dealtCards = Arrays.asList("K", "K", "K");
        isSequence = ScoreHelper.isDealtCardsInSequence(dealtCards);
        assertFalse(isSequence);
        dealtCards = Arrays.asList("Q", "10", "J");
        isSequence = ScoreHelper.isDealtCardsInSequence(dealtCards);
        assertTrue(isSequence);
        dealtCards = Arrays.asList("7", "6", "5");
        isSequence = ScoreHelper.isDealtCardsInSequence(dealtCards);
        assertTrue(isSequence);
    }



    @Test
    public void testIsDealtCardsPair() {
        List<String> dealtCards = Arrays.asList("2", "2", "4");
        boolean isPair = ScoreHelper.isDealtCardsPair(dealtCards);
        assertTrue(isPair);
        dealtCards = Arrays.asList("2", "3", "A");
        isPair = ScoreHelper.isDealtCardsPair(dealtCards);
        assertFalse(isPair);
        dealtCards = Arrays.asList("A", "A", "4");
        isPair = ScoreHelper.isDealtCardsPair(dealtCards);
        assertTrue(isPair);
        dealtCards = Arrays.asList("J", "A", "J");
        isPair = ScoreHelper.isDealtCardsPair(dealtCards);
        assertTrue(isPair);
        dealtCards = Arrays.asList("3", "2", "A");
        isPair = ScoreHelper.isDealtCardsPair(dealtCards);
        assertFalse(isPair);

    }

    @Test
    public void testCalculateTripletScore() {
        List<String> dealtCards = Arrays.asList("5", "5", "5");
        int tripletScore = ScoreHelper.calculateTripletScore(dealtCards);
        assertEquals(tripletScore - AppConstants.TRIPLET_BASE_SCORE, 15);
        dealtCards = Arrays.asList("K", "K", "K");
        tripletScore = ScoreHelper.calculateTripletScore(dealtCards);
        assertEquals(tripletScore - AppConstants.TRIPLET_BASE_SCORE, 39);
        dealtCards = Arrays.asList("A", "A", "A");
        tripletScore = ScoreHelper.calculateTripletScore(dealtCards);
        assertEquals(tripletScore - AppConstants.TRIPLET_BASE_SCORE, 42);
        dealtCards = Arrays.asList("10", "10", "10");
        tripletScore = ScoreHelper.calculateTripletScore(dealtCards);
        assertEquals(tripletScore - AppConstants.TRIPLET_BASE_SCORE, 30);
    }

    @Test
    public void testCalculateSequenceScore() {
        List<String> dealtCards = Arrays.asList("5", "4", "3");
        int sequenceScore = ScoreHelper.calculateSequenceScore(dealtCards);
        assertEquals(sequenceScore - AppConstants.SEQUENCE_BASE_SCORE, 12);
        dealtCards = Arrays.asList("Q", "K", "J");
        sequenceScore = ScoreHelper.calculateSequenceScore(dealtCards);
        assertEquals(sequenceScore - AppConstants.SEQUENCE_BASE_SCORE, 36);
        dealtCards = Arrays.asList("Q", "A", "K");
        sequenceScore = ScoreHelper.calculateSequenceScore(dealtCards);
        assertEquals(sequenceScore - AppConstants.SEQUENCE_BASE_SCORE, 39);
        dealtCards = Arrays.asList("A", "2", "3");
        sequenceScore = ScoreHelper.calculateSequenceScore(dealtCards);
        assertEquals(sequenceScore - AppConstants.SEQUENCE_BASE_SCORE, 6);
    }

    @Test
    public void testCalculatePairScore() {
        List<String> dealtCards = Arrays.asList("5", "5", "4");
        int pairScore = ScoreHelper.calculatePairScore(dealtCards);
        assertEquals(pairScore - AppConstants.PAIR_BASE_SCORE, 10);
        dealtCards = Arrays.asList("K", "K", "J");
        pairScore = ScoreHelper.calculatePairScore(dealtCards);
        assertEquals(pairScore - AppConstants.PAIR_BASE_SCORE, 26);
        dealtCards = Arrays.asList("2", "2", "A");
        pairScore = ScoreHelper.calculatePairScore(dealtCards);
        assertEquals(pairScore - AppConstants.PAIR_BASE_SCORE, 4);
        dealtCards = Arrays.asList("A", "A", "K");
        pairScore = ScoreHelper.calculatePairScore(dealtCards);
        assertEquals(pairScore - AppConstants.PAIR_BASE_SCORE, 28);
    }

    @Test
    public void testCalculateTopCardScore() {
        List<String> dealtCards = Arrays.asList("5", "2", "4");
        int topCardScore = ScoreHelper.calculateTopCardScore(dealtCards);
        assertEquals(topCardScore - AppConstants.TOP_CARD_BASE_SCORE, 5);
        dealtCards = Arrays.asList("A", "K", "J");
        topCardScore = ScoreHelper.calculateTopCardScore(dealtCards);
        assertEquals(topCardScore - AppConstants.TOP_CARD_BASE_SCORE, 14);
        dealtCards = Arrays.asList("3", "K", "A");
        topCardScore = ScoreHelper.calculateTopCardScore(dealtCards);
        assertEquals(topCardScore - AppConstants.TOP_CARD_BASE_SCORE, 14);
        dealtCards = Arrays.asList("10", "K", "J");
        topCardScore = ScoreHelper.calculateTopCardScore(dealtCards);
        assertEquals(topCardScore - AppConstants.TOP_CARD_BASE_SCORE, 13);
    }

    @Test
    public void testCalculateSumOfCardScores() {
        List<String> dealtCards = Arrays.asList("2", "3", "4");
        int sumOfCardValues = ScoreHelper.calculateSumOfCardValues(dealtCards);
        assertEquals(sumOfCardValues, 9);
        dealtCards = Arrays.asList("A", "K", "Q");
        sumOfCardValues = ScoreHelper.calculateSumOfCardValues(dealtCards);
        assertEquals(sumOfCardValues, 39);
        dealtCards = Arrays.asList("J", "J", "J");
        sumOfCardValues = ScoreHelper.calculateSumOfCardValues(dealtCards);
        assertEquals(sumOfCardValues, 33);
        dealtCards = Arrays.asList("10", "A", "2");
        sumOfCardValues = ScoreHelper.calculateSumOfCardValues(dealtCards);
        assertEquals(sumOfCardValues, 26);
    }

    @Test
    public void testGetCardValue() {
        String dealtCard = "A";
        int value = ScoreHelper.getCardValue(dealtCard);
        assertEquals(value, 14);
        dealtCard = "K";
        value = ScoreHelper.getCardValue(dealtCard);
        assertEquals(value, 13);
        dealtCard = "10";
        value = ScoreHelper.getCardValue(dealtCard);
        assertEquals(value, 10);
        dealtCard = "2";
        value = ScoreHelper.getCardValue(dealtCard);
        assertEquals(value, 2);
    }

    @Test
    public void testGetCardFromCardValue() {
        int value = 1;
        String dealtCard = ScoreHelper.getCardFromCardValue(value);
        assertEquals(dealtCard, "A");
        value = 14;
        dealtCard = ScoreHelper.getCardFromCardValue(value);
        assertEquals(dealtCard, "A");
        value = 10;
        dealtCard = ScoreHelper.getCardFromCardValue(value);
        assertEquals(dealtCard, "10");
        value = 2;
        dealtCard = ScoreHelper.getCardFromCardValue(value);
        assertEquals(dealtCard, "2");
    }
}
