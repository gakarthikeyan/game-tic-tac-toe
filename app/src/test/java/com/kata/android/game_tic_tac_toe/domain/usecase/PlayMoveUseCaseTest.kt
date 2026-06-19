package com.kata.android.game_tic_tac_toe.domain.usecase

import com.kata.android.game_tic_tac_toe.domain.model.GameBoardState
import com.kata.android.game_tic_tac_toe.domain.model.GamePlayer
import com.kata.android.game_tic_tac_toe.domain.repository.GameRepository
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class PlayMoveUseCaseTest {

    private val gameRepository: GameRepository = mockk()
    private val playMoveUseCase = PlayMoveUseCase(gameRepository)

    @Test
    fun `play move on empty board places X mark and saves state`(): Unit = runBlocking {
        val initialState = GameBoardState()
        val expectedState = initialState.playMove(0)

        coEvery { gameRepository.getGameState() } returns initialState
        coEvery { gameRepository.saveGameState(expectedState) } returns Unit

        val result = playMoveUseCase(0)
        
        assertEquals(expectedState.gameBoard.cells[0], GamePlayer.X)
        assertEquals(GamePlayer.O, result.currentGamePlayer)
    }

    @Test
    fun `play move returns updated game state`(): Unit = runBlocking {
        val initialState = GameBoardState()
        var state = initialState
        state = state.playMove(0)  // X at 0

        coEvery { gameRepository.getGameState() } returns initialState
        coEvery { gameRepository.saveGameState(state) } returns Unit

        val result = playMoveUseCase(0)

        assertEquals(state, result)
    }
}
