package com.kata.android.game_tic_tac_toe.domain.repository

import com.kata.android.game_tic_tac_toe.domain.model.GameBoardState
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Test
/**
 * Game Tic-Tac-Toe with TDD approach.
 *
 * Repository implementation test for the game save,
 * retrieve state and other operations.
 *
 * @author Karthikeyan G
 */
class GameRepositoryImplTest {

    private val gameRepositoryImpl = GameRepositoryImpl()

    @Test
    fun `initial game state is empty`(): Unit = runBlocking {
        val state = gameRepositoryImpl.getGameState()
        TestCase.assertTrue(state.gameBoard.isEmpty())
    }

     @Test
        fun `can save and retrieve game state`(): Unit = runBlocking {
            val gameBoardState = GameBoardState()
            val updatedState = gameBoardState.playMove(0)

            gameRepositoryImpl.saveGameState(updatedState)
            val retrievedState = gameRepositoryImpl.getGameState()

            TestCase.assertEquals(updatedState, retrievedState)
        }

        @Test
        fun `persists state across multiple operations`(): Unit = runBlocking {
            val gameBoardState = GameBoardState()
            var state = gameBoardState

            state = state.playMove(0)
            gameRepositoryImpl.saveGameState(state)

            var retrievedState = gameRepositoryImpl.getGameState()
            TestCase.assertEquals(state, retrievedState)

            state = retrievedState.playMove(1)
            gameRepositoryImpl.saveGameState(state)

            retrievedState = gameRepositoryImpl.getGameState()
            TestCase.assertEquals(state, retrievedState)
        }
}