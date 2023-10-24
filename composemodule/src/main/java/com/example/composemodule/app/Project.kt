package com.example.composemodule.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composemodule.composed.AlertDialog
import com.example.composemodule.darkMode
import com.example.composemodule.screens.LanguageSelectionScreen
import com.example.composemodule.screens.LoginScreen
import com.example.composemodule.screens.OtpScreen
import com.example.composemodule.screens.SwitchModeScreen
import com.example.composemodule.screens.TermsAndConditionScreen
import com.example.composemodule.ui.theme.ProjectInternTheme

/**This File Contains All The Screens**/


@Composable
fun ProjectApp() {


    val window = com.example.composemodule.model.rememberWindowSizeClass()
    val navController = rememberNavController()

    ProjectInternTheme(window, darkTheme = darkMode) {

        Surface(modifier = Modifier.fillMaxSize()) {

            NavHost(navController = navController, startDestination = "language") {

                composable("language") {
                LanguageSelectionScreen(navController = navController)
            }
                composable("login") {
                    LoginScreen(navController = navController)
                }
                composable("otp") {
                    OtpScreen(navController = navController)
                }
                composable("terms") {
                    TermsAndConditionScreen(navController = navController)
                }
                composable("dialog") {
                    AlertDialog(navController = navController)
                }
                composable("mode") {
                   SwitchModeScreen(navController = navController)
                }
            }

        }
    }
}


@Preview
@Composable
fun ProjectPreview() {
    ProjectApp()
}
