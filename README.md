# Card Game
A backend service for a simple card game of 4 players.

## Rules
* Each player is dealt 3 cards in beginning
* A player wins if he has the highest set of cards
* A high set of cards is defined in decreasing order by:
    * Triplet
    * Sequence
    * Pair
    * Top Card
* Suit of the card does not matter 
* If players have same value cards, the tie is broken by:
    * each tied player is dealt 1 card
    * the player with the highest value card dealt in previous step wins
    * if a tie arises again, repeat above steps

## Usage
To play the game, just hit the api:
```
[GET] localhost:9191/game/new
```
Response:
```
{
    "players": [
        {
            "dealt_cards": ["K","5","4"]
        },
        {
            "dealt_cards": ["10","7","9"]
        },
        {
            "dealt_cards": ["7","Q","2"]
        },
        {
            "dealt_cards": ["10","Q","9"]
        }
    ],
    "winner_player_index": 0
}
```
"winner_player_index" denotes which player won the game.  
Clearly, the above game was won by player no. 1 at index 0 as he has the top card 'K'

## Built With
* Spring boot

### Note
This project was built in approximately 4 hours. Open to suggestions and improvements
