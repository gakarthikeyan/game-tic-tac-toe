package com.kata.android.game_tic_tac_toe.domain.model

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class GameBoardStateTest {

    @Test
    fun `game starts with X player and empty board`() {
        val gameBoardState = GameBoardState()
        assertEquals(GamePlayer.X, gameBoardState.currentGamePlayer)
        assertTrue(gameBoardState.gameBoard.isEmpty())
        assertFalse(gameBoardState.isGameOver)
        assertEquals(GameBoardResult.ONGOING, gameBoardState.gameBoardResult)
    }

    @Test
    fun `after X moves, it's O's turn`() {
        val gameBoardState = GameBoardState()
        val newGameState = gameBoardState.playMove(0)
        assertEquals(GamePlayer.O, newGameState.currentGamePlayer)
    }

    @Test
    fun `after O moves, it's X's turn`() {
        val gameBoardState = GameBoardState()
        var newGameState = gameBoardState.playMove(0)
        newGameState = newGameState.playMove(1)
        assertEquals(GamePlayer.X, newGameState.currentGamePlayer)
    }

    @Test
    fun `game is over when player wins with row`() {
        val gameBoardState = GameBoardState()
        var state = gameBoardState
        // X: 0, O: 3, X: 1, O: 4, X: 2 (X wins)
        state = state.playMove(0)  // X at 0
        state = state.playMove(3)  // O at 3
        state = state.playMove(1)  // X at 1
        state = state.playMove(4)  // O at 4
        state = state.playMove(2)  // X at 2 (wins)

        assertTrue(state.isGameOver)
        assertEquals(GameBoardResult.X_WINS, state.gameBoardResult)
    }


}
