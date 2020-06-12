package com.nimesh.card_game.service.helper;

import com.nimesh.card_game.entity.Game;
import com.nimesh.card_game.entity.Player;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GameHelper {

    public static void simulateGame(Game game) {
        List<Player> players = isGameClashed(game) ?
                getClashedPlayers(game) : game.getPlayers();
        ScoreHelper.calculateScoresOfPlayers(players);
        List<Player> playersWithHighestScore = ScoreHelper.getPlayersWithHighestScore(players);
        if (playersWithHighestScore.size() == 1)
            game.declareWinner(playersWithHighestScore.get(0));
        else if (playersWithHighestScore.size() > 1) {
            if (52 - game.getDealtCardIndexes().size() < playersWithHighestScore.size())
                return;
            for (Player clashedPlayer : playersWithHighestScore)
                DealerHelper.dealCardToPlayer(clashedPlayer, game.getDealtCardIndexes());
            simulateGame(game);
        } else
            throw new RuntimeException("No player with highest score");
    }

    static int getMaxDealtCards(Game game) {
        return game.getPlayers().stream()
                .max(Comparator.comparing(player -> player.getDealtCards().size()))
                .orElseThrow(RuntimeException::new).getDealtCards().size();
    }

    private static boolean isGameClashed(Game game) {
        return getMaxDealtCards(game) > 3;
    }

    static List<Player> getClashedPlayers(Game game) {
        int maxDealtCards = getMaxDealtCards(game);
        return game.getPlayers().stream()
                .filter(player -> player.getDealtCards().size() == maxDealtCards)
                .collect(Collectors.toList());
    }
}
