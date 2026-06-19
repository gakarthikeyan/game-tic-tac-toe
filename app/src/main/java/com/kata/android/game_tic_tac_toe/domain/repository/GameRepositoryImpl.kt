package com.kata.android.game_tic_tac_toe.domain.repository

import com.kata.android.game_tic_tac_toe.domain.model.GameBoardState
/**
 * Game Tic-Tac-Toe with TDD approach.
 *
 * Repository implementation for the game save
 * and retrieve state.
 *
 * @author Karthikeyan G
 */
class GameRepositoryImpl : GameRepository {
    private var gameBoardState: GameBoardState = GameBoardState()

    override suspend fun getGameState(): GameBoardState {
        return gameBoardState
    }

     override suspend fun saveGameState(state: GameBoardState) {
        gameBoardState = state
    }
}