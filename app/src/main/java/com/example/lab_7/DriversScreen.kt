package com.example.lab_7

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.navigation.NavController

@Composable
fun DriversScreen(navController: NavController) {
    var drivers = remember {
        mutableStateListOf<String>()
    }
    var driver by remember {
        mutableStateOf("")
    }
    Column() {
        Row() {
            Button(
                onClick = {navController.popBackStack()},
                modifier = Modifier.testTag("backButton")
            ) {
                Text("Home")

            }
            Text("FormulaZero Drivers")
        }
        Row() {
            TextField(
                value = driver,
                onValueChange = {driver = it},
                label = {
                    Text("Driver")
                },
                modifier = Modifier.testTag("driverInput")
            )
            Button(
                onClick = {
                    if (driver.isNotBlank()) {
                        drivers.add(driver)
                        driver = ""
                    }
                },
                modifier = Modifier.testTag("addDriverButton")
            ) { }
        }
        Row() {
            Button(
                onClick = {
                    drivers.clear()
                },
                modifier = Modifier.testTag("clearDrivers")
            ) {
                Text("Clear Driver List")
            }
        }
    }
}