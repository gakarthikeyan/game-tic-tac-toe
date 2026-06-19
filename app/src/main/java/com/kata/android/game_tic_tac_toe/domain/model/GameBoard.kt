package com.kata.android.game_tic_tac_toe.domain.model

/**
 * Game Tic-Tac-Toe with TDD approach.
 *
 * Game board model for check multiple approch
 * like fullfil the Board state casestudy requirements and cover all
 * possible scenarios.
 *
 * @author Karthikeyan G
 */
data class GameBoard(
    val cells: Array<GamePlayer?> = Array(9) { null }
) {
    fun placeMark(position: Int, gamePlayer: GamePlayer): GameBoard {
        if (!isCellEmpty(position)) return this
        
        val newCells = cells.copyOf()
        newCells[position] = gamePlayer
        return GameBoard(newCells)
    }

    fun isCellEmpty(position: Int): Boolean = cells[position] == null

    fun isFull(): Boolean = cells.all { it != null }

    fun isEmpty(): Boolean = cells.all { it == null }

    fun hasWinningRow(gamePlayer: GamePlayer): Boolean {
        // Rows: 0-1-2, 3-4-5, 6-7-8
        for (row in 0..2) {
            val start = row * 3
            if (cells[start] == gamePlayer && cells[start + 1] == gamePlayer && cells[start + 2] == gamePlayer) {
                return true
            }
        }
        return false
    }

    fun hasWinningColumn(gamePlayer: GamePlayer): Boolean {
        // Columns: 0-3-6, 1-4-7, 2-5-8
        for (col in 0..2) {
            if (cells[col] == gamePlayer && cells[col + 3] == gamePlayer && cells[col + 6] == gamePlayer) {
                return true
            }
        }
        return false
    }

    fun hasWinningDiagonal(gamePlayer: GamePlayer): Boolean {
        // Main diagonal: 0-4-8
        if (cells[0] == gamePlayer && cells[4] == gamePlayer && cells[8] == gamePlayer) {
            return true
        }
        // Anti-diagonal: 2-4-6
        if (cells[2] == gamePlayer && cells[4] == gamePlayer && cells[6] == gamePlayer) {
            return true
        }
        return false
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is GameBoard) return false
        return cells.contentEquals(other.cells)
    }

    override fun hashCode(): Int {
        return cells.contentHashCode()
    }
}
