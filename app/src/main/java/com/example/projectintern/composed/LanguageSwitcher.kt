package com.example.projectintern.composed

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.projectintern.model.updateAppLanguage
import com.example.projectintern.utils.LanguageSelection

@Composable
fun LanguageSwitcherButton( text : String) {

    val context = LocalContext.current
    var selectedLanguage by remember { mutableStateOf(LanguageSelection.ENGLISH) }


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), contentAlignment = Alignment.TopCenter
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = text, color = MaterialTheme.colorScheme.primary)
            Spacer(modifier = Modifier.padding(16.dp))

            Switch(
                checked = selectedLanguage == LanguageSelection.BANGLA,
                onCheckedChange = {
                    selectedLanguage = if (it) LanguageSelection.BANGLA else LanguageSelection.ENGLISH
                    updateAppLanguage(context, context.resources, selectedLanguage)
                }
            )
        }


    }


}