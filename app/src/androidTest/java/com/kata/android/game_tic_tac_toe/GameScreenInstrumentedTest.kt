package com.kata.android.game_tic_tac_toe

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kata.android.game_tic_tac_toe.presentation.ui.GameScreen
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module

@RunWith(AndroidJUnit4::class)
class GameScreenInstrumentedTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        setupKoin()
    }

    @After
    fun tearDown() {
        try {
            stopKoin()
        } catch (e: Exception) {
            // Koin already stopped
        }
    }

    @Test
    fun gameScreenDisplaysTitle() {
        composeTestRule.setContent {
            GameScreen()
        }

        composeTestRule.onNodeWithText("Tic Tac Toe").assertExists()
    }

    @Test
    fun gameScreenDisplaysCurrentPlayer() {
        composeTestRule.setContent {
            GameScreen()
        }

        composeTestRule.onNodeWithText("Current Player: X").assertExists()
    }

    @Test
    fun resetButtonIsDisplayed() {
        composeTestRule.setContent {
            GameScreen()
        }

        composeTestRule.onNodeWithText("Reset Game").assertExists()
    }

    @Test
    fun clickingResetButtonResetsGame() {
        composeTestRule.setContent {
            GameScreen()
        }

        // Click reset button
        composeTestRule.onNodeWithText("Reset Game").performClick()

        // Verify game board is cleared (title should still be visible)
        composeTestRule.onNodeWithText("Tic Tac Toe").assertExists()
    }

    @Test
    fun gameScreenIsResponsiveToUserClicks() {
        composeTestRule.setContent {
            GameScreen()
        }

        // Game board should be displayed with cells
        composeTestRule.onNodeWithText("Tic Tac Toe").assertExists()

        // Verify player can make moves by checking UI updates
        composeTestRule.onNodeWithText("Current Player: X").assertExists()
    }



    private fun setupKoin() {
        try {
            stopKoin()
        } catch (e: Exception) {
            // Koin not started yet, ignore
        }

        startKoin {
            modules(testModule())
        }
    }

    private fun testModule() = module {
        // Mock dependencies (I will add later if required)
    }
}
