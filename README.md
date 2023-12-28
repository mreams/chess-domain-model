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

