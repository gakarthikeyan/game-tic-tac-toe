package com.kata.android.game_tic_tac_toe.domain.repository

import com.kata.android.game_tic_tac_toe.domain.model.GameBoardState

interface GameRepository {
    suspend fun getGameState(): GameBoardState
}
