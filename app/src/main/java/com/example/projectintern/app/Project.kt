package com.example.projectintern.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projectintern.darkMode
import com.example.projectintern.model.rememberWindowSizeClass
import com.example.projectintern.screens.LoginScreen
import com.example.projectintern.screens.OtpScreen
import com.example.projectintern.ui.theme.ProjectInternTheme


/**This File Contains All The Screens**/
@Composable
fun ProjectApp() {

    val window = rememberWindowSizeClass()

    ProjectInternTheme(window, darkTheme = darkMode) {

        val navController = rememberNavController()

        Surface(modifier = Modifier.fillMaxSize()) {

        }
    }
}

@Preview
@Composable
fun ProjectPreview() {
    ProjectApp()
}
