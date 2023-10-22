package com.example.projectintern.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projectintern.composed.AlertDialog
import com.example.projectintern.darkMode
import com.example.projectintern.model.rememberWindowSizeClass
import com.example.projectintern.screens.LanguageSelectionScreen
import com.example.projectintern.screens.LoginScreen
import com.example.projectintern.screens.OtpScreen
import com.example.projectintern.screens.SwitchModeScreen
import com.example.projectintern.screens.TermsAndConditionScreen
import com.example.projectintern.ui.theme.ProjectInternTheme

/**This File Contains All The Screens**/
@Composable
fun ProjectApp() {


    val window = rememberWindowSizeClass()
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
