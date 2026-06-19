package com.kata.android.game_tic_tac_toe.domain.model

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

/**
 * Game Tic-Tac-Toe with TDD approach.
 *
 * Fullfil the Board state casestudy requirements and cover all
 * possible scenarios.
 *
 * @author Karthikeyan G
 */
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

    @Test
    fun `game is over when player wins with column`() {
        val gameBoardState = GameBoardState()
        var state = gameBoardState
        // X: 0, O: 1, X: 3, O: 2, X: 6 (X wins)
        state = state.playMove(0)  // X at 0
        state = state.playMove(1)  // O at 1
        state = state.playMove(3)  // X at 3
        state = state.playMove(2)  // O at 2
        state = state.playMove(6)  // X at 6 (wins)

        assertTrue(state.isGameOver)
        assertEquals(GameBoardResult.X_WINS, state.gameBoardResult)
    }

    @Test
    fun `game is over when player wins with diagonal`() {
        val gameBoardState = GameBoardState()
        var state = gameBoardState
        // X: 0, O: 1, X: 4, O: 2, X: 8 (X wins)
        state = state.playMove(0)  // X at 0
        state = state.playMove(1)  // O at 1
        state = state.playMove(4)  // X at 4
        state = state.playMove(2)  // O at 2
        state = state.playMove(8)  // X at 8 (wins)

        assertTrue(state.isGameOver)
        assertEquals(GameBoardResult.X_WINS, state.gameBoardResult)
    }

    @Test
    fun `game is draw when board is full and no winner`() {
        val gameBoardState = GameBoardState()
        var state = gameBoardState
        // X: 0, O: 1, X: 2, O: 3, X: 5, O: 4, X: 6, X: 7, O: 8
        state = state.playMove(0)  // X
        state = state.playMove(1)  // O
        state = state.playMove(2)  // X
        state = state.playMove(3)  // O
        state = state.playMove(5)  // X
        state = state.playMove(4)  // O
        state = state.playMove(6)  // X
        state = state.playMove(8)  // X
        state = state.playMove(7)  // O

        assertTrue(state.isGameOver)
        assertEquals(GameBoardResult.DRAW, state.gameBoardResult)
    }


}
