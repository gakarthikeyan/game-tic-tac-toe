package com.kata.android.game_tic_tac_toe.presentation.di

import com.kata.android.game_tic_tac_toe.domain.repository.GameRepository
import com.kata.android.game_tic_tac_toe.domain.repository.GameRepositoryImpl
import org.koin.dsl.module

val gameModule = module {
    // Repository
    single<GameRepository> { GameRepositoryImpl() }

}
