package com.kata.android.game_tic_tac_toe.domain.repository

import com.kata.android.game_tic_tac_toe.domain.model.GameBoardState
/**
 * Game Tic-Tac-Toe with TDD approach.
 *
 * Repository interface for the game save
 * and retrieve state.
 *
 * @author Karthikeyan G
 */
interface GameRepository {
    suspend fun getGameState(): GameBoardState
    suspend fun saveGameState(state: GameBoardState)
}
