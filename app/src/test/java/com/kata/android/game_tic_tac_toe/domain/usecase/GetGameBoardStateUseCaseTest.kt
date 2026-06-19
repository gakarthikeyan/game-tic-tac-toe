package com.kata.android.game_tic_tac_toe.domain.usecase

import com.kata.android.game_tic_tac_toe.domain.model.GameBoardState
import com.kata.android.game_tic_tac_toe.domain.repository.GameRepository
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test
/**
 * Game Tic-Tac-Toe with TDD approach.
 *
 * Test the use case for retrieving the current
 * from the repository.
 *
 * @author Karthikeyan G
 */
class GetGameBoardStateUseCaseTest {

    private val gameRepository: GameRepository = mockk()
    private val getGameStateUseCase = GetGameStateUseCase(gameRepository)

    @Test
    fun `returns current game state from repository`(): Unit = runBlocking {
        val gameBoardState = GameBoardState()
        coEvery { gameRepository.getGameState() } returns gameBoardState
        
        val result = getGameStateUseCase()
        
        assertEquals(gameBoardState, result)
    }
}
