# chess-domain-model
A domain model for the game of chess.

Models the following rules:
  - A pawn may more forward one step at a time. 
  - A pawn may move two steps forward but only if it is the pawn’s first move
  - a pawn may capture diagonally but only can capture a piece of the different colour
  - a pawn may only move forward if the square is unoccupied
  - a bishop may move in a diagonal direction but only up to the first occupied square regardless of the colour
  - a bishop may capture a piece but only of different colour
  - a rook may move horizontally or vertically but only up to the first occupied square regardless of colour
  - a rook may capture a piece only of different colour
  - no piece may move off of the board’s boundaries
  
## Architecture Notes

Logic is divided up between the pieces and the board. Each piece is in charge of deciding whether a given move is valid for its type, and the board is in charge of deciding whether the move can actually happen - nothing in the way, valid capture at the end if a capture is being attempted, move stays within the limits of the board, etc.

The board is modelled as a 2-D array. X and Y start at the bottom left corner, making board\[0\]\[0-7\] the left edge of the board and board\[7\]\[0-7\] the right edge of the board

Different exceptions are thrown for various types of invalid moves:
- NoPieceFound - thrown when there is no piece found at the start coordinates
- MoveOutOfBounds - thrown when the move would move the piece off the board 
- InvalidMove - thrown when the move is not valid for the piece type, for example trying to move a bishop sideways
- InvalidCapture - thrown when the move attempted to capture a piece of the same colour 

## Testing notes

Tests include 
- ensuring each piece returns true for valid moves and false for invalid moves
    - bishops can move diagonally forward-left, forward-right, backward-left, backward-right
    - bishops cannot move straight forward, backward, left, right
    - pawns can move forward 2 steps on their first move only
    - pawns cannot move forward 2 steps on any subsequent move
    - pawns cannot move sideways or backward
    - pawns can capture diagonally only, not forward
    - rooks can move forward, back, left, or right
    - rooks cannot move diagonally in any direction
- ensuring the board returns true for valid moves and false for invalid moves
    - no piece can move through another piece
    - moves fail if there is no piece at the given start location
    - no piece can move off the board
    - all pieces can only capture a piece of a different colour
  

## Logging notes

Basic logging with log4j. Intention is to log json objects that can be ingested into a log aggregation/search/display stack like ELK.
 

