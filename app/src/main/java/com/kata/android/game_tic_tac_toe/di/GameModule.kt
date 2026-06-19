package com.kata.android.game_tic_tac_toe.di

import com.kata.android.game_tic_tac_toe.domain.repository.GameRepository
import com.kata.android.game_tic_tac_toe.domain.repository.GameRepositoryImpl
import com.kata.android.game_tic_tac_toe.domain.usecase.GetGameStateUseCase
import com.kata.android.game_tic_tac_toe.domain.usecase.PlayMoveUseCase
import com.kata.android.game_tic_tac_toe.domain.usecase.ResetGameUseCase
import org.koin.dsl.module
/**
 * Game Tic-Tac-Toe with TDD approach.
 *
 * Koin dependency injection module for the game
 * repository, usecase and viewmodel.
 *
 * @author Karthikeyan G
 */
val gameModule = module {
    // Repository
    single<GameRepository> { GameRepositoryImpl() }

    // Use Cases
    factory { GetGameStateUseCase(get()) }
    factory { PlayMoveUseCase(get()) }
    factory { ResetGameUseCase(get()) }
}
