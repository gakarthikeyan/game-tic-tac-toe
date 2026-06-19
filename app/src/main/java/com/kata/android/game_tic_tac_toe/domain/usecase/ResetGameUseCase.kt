package com.kata.android.game_tic_tac_toe.domain.usecase

import com.kata.android.game_tic_tac_toe.domain.model.GameBoardState
import com.kata.android.game_tic_tac_toe.domain.repository.GameRepository

class ResetGameUseCase(private val gameRepository: GameRepository) {
    suspend operator fun invoke(): GameBoardState {
        val newState = GameBoardState()
        gameRepository.saveGameState(newState)
        return newState
    }
}
