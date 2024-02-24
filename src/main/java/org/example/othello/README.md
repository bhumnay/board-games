# OTHELLO

## Description

This is a simple implementation of the game Othello. It is a two player game where the players take turns to place a
piece on the board. The game ends when there are no more moves left for either player. The player with the most pieces
on the board wins.

## How to run

1. Clone the repository
2. Open the project in your favorite IDE, I use IntelliJ IDEA Community Edition
3. Run the main method in the `Game` class of the game you want to play
4. Play the game on the console
5. Enjoy!

By default, the game is set to be played by a human and a bot. You can change the `Othello` class to do following
configurations:

- Make 2 humans play against each other
- Make 2 bots play against each other
- Assign playing strategies of your choice to the bots

# How to play

```
Player 1: BLACK
Player 2: WHITE
(0,0)|(0,1)|(0,2)|(0,3)
(1,0)|  B  |  W  |(1,3)
(2,0)|  W  |  B  |(2,3)
(3,0)|(3,1)|(3,2)|(3,3)


Player BLACK move
Enter row for next move :

1
Enter column for next move :
3
(0,0)|(0,1)|(0,2)|(0,3)
(1,0)|  B  |  B  |  B  
(2,0)|  W  |  B  |(2,3)
(3,0)|(3,1)|(3,2)|(3,3)


Player WHITE move
(0,0)|(0,1)|(0,2)|  W  
(1,0)|  B  |  W  |  B  
(2,0)|  W  |  B  |(2,3)
(3,0)|(3,1)|(3,2)|(3,3)
...
```