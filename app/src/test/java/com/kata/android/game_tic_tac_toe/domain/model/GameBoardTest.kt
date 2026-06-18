package com.kata.android.game_tic_tac_toe.domain.model

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
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

    @Test
    fun `cell is not empty when occupied`() {
        val gameBoard = GameBoard()
        val newBoard = gameBoard.placeMark(0, GamePlayer.X)
        assertFalse(newBoard.isCellEmpty(0))
    }

    @Test
    fun `cannot place mark on already occupied cell`() {
        val gameBoard = GameBoard()
        val newBoard = gameBoard.placeMark(0, GamePlayer.X)
        val result = newBoard.placeMark(0, GamePlayer.O)
        assertEquals(newBoard, result)
    }

    @Test
    fun `board is full when all cells are occupied`() {
        val gameBoard = GameBoard(
            cells = arrayOf(
                GamePlayer.X, GamePlayer.O, GamePlayer.X,
                GamePlayer.O, GamePlayer.X, GamePlayer.O,
                GamePlayer.O, GamePlayer.X, GamePlayer.X
            )
        )
        assertTrue(gameBoard.isFull())
    }
}
