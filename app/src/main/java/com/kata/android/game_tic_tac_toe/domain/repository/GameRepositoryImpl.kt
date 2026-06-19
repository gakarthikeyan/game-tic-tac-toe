package com.kata.android.game_tic_tac_toe.domain.repository

import com.kata.android.game_tic_tac_toe.domain.model.GameBoardState

class GameRepositoryImpl : GameRepository {
    private var gameBoardState: GameBoardState = GameBoardState()

    override suspend fun getGameState(): GameBoardState {
        return gameBoardState
    }

     override suspend fun saveGameState(state: GameBoardState) {
        gameBoardState = state
    }
}