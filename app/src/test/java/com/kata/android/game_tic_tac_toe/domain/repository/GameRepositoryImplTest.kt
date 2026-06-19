package com.kata.android.game_tic_tac_toe.domain.repository

import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GameRepositoryImplTest {

    private val gameRepositoryImpl = GameRepositoryImpl()

    @Test
    fun `initial game state is empty`(): Unit = runBlocking {
        val state = gameRepositoryImpl.getGameState()
        TestCase.assertTrue(state.gameBoard.isEmpty())
    }


}