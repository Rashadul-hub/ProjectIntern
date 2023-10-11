package com.example.projectintern.composed

import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.example.projectintern.model.updateAppLanguage
import com.example.projectintern.utils.LanguageSelection

@Composable
fun LanguageSwitcherButton() {

    val context = LocalContext.current
    var selectedLanguage by remember { mutableStateOf(LanguageSelection.ENGLISH) }
    Switch(
        checked = selectedLanguage == LanguageSelection.BANGLA,
        onCheckedChange = {
            selectedLanguage = if (it) LanguageSelection.BANGLA else LanguageSelection.ENGLISH
            updateAppLanguage(context, context.resources, selectedLanguage)
        }
    )
}