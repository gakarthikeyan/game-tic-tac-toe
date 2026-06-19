package com.kata.android.game_tic_tac_toe.domain.model
/**
 * Game Tic-Tac-Toe with TDD approach.
 *
 * Enums for game player and game board result.
 *
 * @author Karthikeyan G
 */
enum class GamePlayer {
    X, O;
    
    fun opponent(): GamePlayer = if (this == X) O else X
}
