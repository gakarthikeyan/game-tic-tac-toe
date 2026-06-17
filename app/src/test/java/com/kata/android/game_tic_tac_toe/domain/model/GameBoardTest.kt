package com.kata.android.game_tic_tac_toe.domain.model

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test

class GameBoardTest {

    @Test
    fun `board is created with 9 empty cells`() {
        val gameBoard = GameBoard()
        assertEquals(9, gameBoard.cells.size)
        assertTrue(gameBoard.cells.all { it == null })
    }

    @Test
    fun `can place player symbol on empty cell`() {
        val gameBoard = GameBoard()
        val newBoard = gameBoard.placeMark(0, GamePlayer.X)
        assertEquals(GamePlayer.X, newBoard.cells[0])
    }

    @Test
    fun `cell is empty when position is null`() {
        val gameBoard = GameBoard()
        assertTrue(gameBoard.isCellEmpty(0))
    }


}
