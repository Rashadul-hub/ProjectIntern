package com.example.projectintern.app

import DemoLoginScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.projectintern.darkMode
import com.example.projectintern.model.rememberWindowSizeClass
import com.example.projectintern.screens.LandscapeScreen
import com.example.projectintern.screens.LoginScreen
import com.example.projectintern.screens.PortraitScreen
import com.example.projectintern.ui.theme.AppTheme
import com.example.projectintern.ui.theme.ProjectInternTheme
import com.example.projectintern.utils.LanguageSelection
import com.example.projectintern.utils.Orientation


/**This File Contains All The Screens**/
@Composable
fun ProjectApp() {


    val window = rememberWindowSizeClass()
    ProjectInternTheme(window, darkTheme = darkMode) {
        Surface(modifier = Modifier.fillMaxSize()) {

            LoginScreen()
//            if (AppTheme.orientation == Orientation.Portrait) {
//             LoginScreen()
//
//            } else {
//                LandscapeScreen()
//            }
        }


    }

}

@Preview
@Composable
fun ProjectPreview() {
    ProjectApp()
}