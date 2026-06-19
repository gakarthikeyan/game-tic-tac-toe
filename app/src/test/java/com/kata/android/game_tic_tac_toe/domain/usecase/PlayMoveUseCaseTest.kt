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
    fun `play move on empty board places X mark state`(): Unit = runBlocking {
        val initialState = GameBoardState()
        val expectedState = initialState.playMove(0)
        coEvery { gameRepository.getGameState() } returns initialState
        val result = playMoveUseCase(0)
        
        assertEquals(expectedState.gameBoard.cells[0], GamePlayer.X)
        assertEquals(GamePlayer.O, result.currentGamePlayer)
    }

}
