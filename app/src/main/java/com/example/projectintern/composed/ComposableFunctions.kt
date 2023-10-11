package com.example.projectintern.composed


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectintern.darkMode
import com.example.projectintern.ui.theme.AppTheme

@Composable
fun TextHeadLine(text: String, color: Color) {
    Text(
        "$text",
        style = MaterialTheme.typography.headlineSmall,
        color = Color.White
    )

}

@Composable
fun ComposableButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Color.Blue
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(AppTheme.dimens.mediumLarge),
        shape = CircleShape
    ) {
        Text(
            text = "Lets Go",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(AppTheme.dimens.medium)
        )
    }
}


@Composable
fun ThemeSwitch() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), contentAlignment = Alignment.TopCenter
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "DarkMode", fontSize = 40.sp)
            Spacer(modifier = Modifier.padding(16.dp))

            Switch(checked = darkMode, onCheckedChange = { darkMode = !darkMode })
        }

    }
}


@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier.fillMaxWidth().heightIn(min = 80.dp),
        style = TextStyle(
            fontSize =  18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        )
    )
}


@Preview
@Composable
fun ViewButton() {
    ComposableButton()
}

@Preview
@Composable
fun ThemeSwitcherPreview() {
    ThemeSwitch()
}