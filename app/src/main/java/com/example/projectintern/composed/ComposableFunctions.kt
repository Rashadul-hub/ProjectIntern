package com.example.projectintern.composed


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectintern.R
import com.example.projectintern.darkMode
import com.example.projectintern.ui.theme.CustomButtonColor
import com.example.projectintern.ui.theme.OnPrimaryLight
import com.example.projectintern.ui.theme.SurfaceDark




//SignInTitle
@Composable
fun SignInTitle(text: String) {
    Text(
        text = "$text",
        style = TextStyle(
            fontSize = 17.sp,
            fontFamily = FontFamily(Font(R.font.inter_bold)),
            fontWeight = FontWeight(700),
            color = Color(0xFF37474F),
            textAlign = TextAlign.Center,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()

    )
}



///Send OTP Button
@Composable
fun CustomOTPButton(
    buttonText: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.elevatedButtonColors(containerColor = Color.Transparent),
        modifier = Modifier
            .fillMaxWidth() // Take the full available width
            .height(55.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 6.dp,
                    topEnd = 16.dp,
                    bottomStart = 16.dp,
                    bottomEnd = 16.dp
                )
            )
            .background(CustomButtonColor),

        ) {
        Text(
            text = buttonText,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            letterSpacing = (-0.3).sp,
            modifier = Modifier
                .fillMaxWidth() // Take the full available width
                .fillMaxHeight() // Take the full available height
                .padding(horizontal = 16.dp) ,// Add horizontal padding
            color = OnPrimaryLight,
            fontWeight = FontWeight(600),
            fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
        )
    }
}



///Switch Theme Mode
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
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = SurfaceDark,
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier.fillMaxWidth(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = SurfaceDark,
        textAlign = TextAlign.Center
    )
}


@Preview
@Composable
fun ViewButton2() {
    CustomOTPButton(buttonText = "shdjka" , onClick = {})
}

@Preview
@Composable
fun ThemeSwitcherPreview() {
    ThemeSwitch()
}
