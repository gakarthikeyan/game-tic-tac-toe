package com.kata.android.game_tic_tac_toe.domain.model

/**
 * Game Tic-Tac-Toe with TDD approach.
 *
 * GameBoardState represents the state of the game board. Check if a player has won,
 * if the board is full, or if the game is still ongoing.
 *
 * @author Karthikeyan G
 */
data class GameBoardState(
    val gameBoard: GameBoard = GameBoard(),
    val currentGamePlayer: GamePlayer = GamePlayer.X,
    val isGameOver: Boolean = false,
    val gameBoardResult: GameBoardResult = GameBoardResult.ONGOING
) {
    fun playMove(position: Int): GameBoardState {
        if (isGameOver) return this
        if (!gameBoard.isCellEmpty(position)) return this

        val newBoard = gameBoard.placeMark(position, currentGamePlayer)
        
        // Check if current player(X or O) won
        if (newBoard.hasWinningRow(currentGamePlayer) ||
            newBoard.hasWinningColumn(currentGamePlayer) ||
            newBoard.hasWinningDiagonal(currentGamePlayer)) {
            val result = if (currentGamePlayer == GamePlayer.X) GameBoardResult.X_WINS else GameBoardResult.O_WINS
            return GameBoardState(
                gameBoard = newBoard,
                currentGamePlayer = currentGamePlayer,
                isGameOver = true,
                gameBoardResult = result
            )
        }

        // Check if board is full (draw) - no possibility for player to win
        if (newBoard.isFull()) {
            return GameBoardState(
                gameBoard = newBoard,
                currentGamePlayer = currentGamePlayer,
                isGameOver = true,
                gameBoardResult = GameBoardResult.DRAW
            )
        }

        // Switch to next player (O -> X or X -> O)
        return GameBoardState(
            gameBoard = newBoard,
            currentGamePlayer = currentGamePlayer.opponent(),
            isGameOver = false,
            gameBoardResult = GameBoardResult.ONGOING
        )
    }
}
