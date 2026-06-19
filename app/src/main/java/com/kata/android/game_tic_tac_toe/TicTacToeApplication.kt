package com.kata.android.game_tic_tac_toe

import android.app.Application
import com.kata.android.game_tic_tac_toe.presentation.di.gameModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
/**
 * Game Tic-Tac-Toe with TDD approach.
 *
 * Koin dependency injection in  application class.
 *
 * @author Karthikeyan G
 */
class TicTacToeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TicTacToeApplication)
            modules(gameModule)
        }
    }
}
