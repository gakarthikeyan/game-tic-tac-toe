package com.kata.android.game_tic_tac_toe.domain.usecase

import com.kata.android.game_tic_tac_toe.domain.model.GameBoardState
import com.kata.android.game_tic_tac_toe.domain.repository.GameRepository
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ResetGameUseCaseTest {

    private val gameRepository: GameRepository = mockk()
    private val resetGameUseCase = ResetGameUseCase(gameRepository)

    @Test
    fun `resets game to initial state and saves it`(): Unit = runBlocking {
        coEvery { gameRepository.saveGameState(GameBoardState()) } returns Unit
        val result = resetGameUseCase()
        assertTrue(result.gameBoard.isEmpty())
        assertEquals(GameBoardState(), result)
    }
}
