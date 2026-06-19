package com.kata.android.game_tic_tac_toe.domain.model

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test
/**
 * Game Tic-Tac-Toe with TDD approach.
 *
 * Test all the cells of the board. Check if a player has won,
 * if the board is full, or if the game is still ongoing.
 * Already occupied cases, etc.
 *
 * @author Karthikeyan G
 */
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

    @Test
    fun `board is not full when there are empty cells`() {
        val gameBoard = GameBoard()
        assertFalse(gameBoard.isFull())
    }

    @Test
    fun `can check if player has winning row`() {
        val gameBoard = GameBoard(
            cells = arrayOf(
                GamePlayer.X, GamePlayer.X, GamePlayer.X,
                null, null, null,
                null, null, null
            )
        )
        assertTrue(gameBoard.hasWinningRow(GamePlayer.X))
    }

    @Test
    fun `player without winning row returns false`() {
        val gameBoard = GameBoard(
            cells = arrayOf(
                GamePlayer.X, GamePlayer.O, GamePlayer.X,
                null, null, null,
                null, null, null
            )
        )
        assertFalse(gameBoard.hasWinningRow(GamePlayer.X))
    }

    @Test
    fun `can check if player has winning column`() {
        val gameBoard = GameBoard(
            cells = arrayOf(
                GamePlayer.X, null, null,
                GamePlayer.X, null, null,
                GamePlayer.X, null, null
            )
        )
        assertTrue(gameBoard.hasWinningColumn(GamePlayer.X))
    }

    @Test
    fun `player without winning column returns false`() {
        val gameBoard = GameBoard(
            cells = arrayOf(
                GamePlayer.X, null, null,
                GamePlayer.O, null, null,
                GamePlayer.X, null, null
            )
        )
        assertFalse(gameBoard.hasWinningColumn(GamePlayer.X))
    }

    @Test
    fun `can check if player has winning diagonal (top-left to bottom-right)`() {
        val gameBoard = GameBoard(
            cells = arrayOf(
                GamePlayer.X, null, null,
                null, GamePlayer.X, null,
                null, null, GamePlayer.X
            )
        )
        assertTrue(gameBoard.hasWinningDiagonal(GamePlayer.X))
    }

    @Test
    fun `can check if player has winning diagonal (top-right to bottom-left)`() {
        val gameBoard = GameBoard(
            cells = arrayOf(
                null, null, GamePlayer.X,
                null, GamePlayer.X, null,
                GamePlayer.X, null, null
            )
        )
        assertTrue(gameBoard.hasWinningDiagonal(GamePlayer.X))
    }


}
