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


## Built With
* Spring boot

### Note
This project was built in approximately 4 hours. Open to suggestions and improvements
