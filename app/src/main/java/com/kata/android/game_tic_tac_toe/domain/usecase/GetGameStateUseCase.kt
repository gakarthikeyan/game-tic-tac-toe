package com.kata.android.game_tic_tac_toe.domain.usecase

import com.kata.android.game_tic_tac_toe.domain.model.GameBoardState
import com.kata.android.game_tic_tac_toe.domain.repository.GameRepository
/**
 * Game Tic-Tac-Toe with TDD approach.
 *
 * Use case for retrieving the current
 * game state from the repository.
 *
 * @author Karthikeyan G
 */
class GetGameStateUseCase(private val gameRepository: GameRepository) {
    suspend operator fun invoke(): GameBoardState {
        return gameRepository.getGameState()
    }
}
