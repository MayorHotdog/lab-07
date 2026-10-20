package com.example.lab_7

import androidx.compose.ui.test.junit4.v2.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


//Verify that you can properly go from the HomeScreen to the DriversScreen
//Verify that you can properly add at least one driver, and if that driver is properly displayed
//Verify that you can properly clear the driver(s) from the list
//Verify that the back button takes you back to the HomeScreen

@RunWith(AndroidJUnit4::class)
class DriversScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()

        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Speedy McWheels")

        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        composeTestRule
            .onNodeWithText("Speedy McWheels")
            .assertExists()

        composeTestRule
            .onNodeWithTag("clearDrivers")
            .performClick()

        composeTestRule
            .onNodeWithText("Speedy McWheels")
            .assertDoesNotExist()

        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}