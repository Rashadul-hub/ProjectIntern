package com.example.projectintern.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.projectintern.R
import com.example.projectintern.composed.ComposableButton
import com.example.projectintern.composed.TextHeadLine
import com.example.projectintern.composed.ThemeSwitch
import com.example.projectintern.ui.theme.AppTheme

@Composable
fun LandscapeScreen() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "img2",
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            topEnd = AppTheme.dimens.medium,
                            bottomEnd = AppTheme.dimens.medium
                        )
                    )
                    .fillMaxHeight(),
                contentScale = ContentScale.FillHeight
            )
            TextHeadLine(text = "Welcome", color = Color.White)
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(2f)
                .padding(AppTheme.dimens.medium),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                "This Application Supports all screen sizes & landscape mode",
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center
            )
            Text(
                "You can have the maximum flexibility regarding your UI using this approach",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )
            ThemeSwitch() // Theme Switch Mode
            ComposableButton()
        }

    }
}

@Preview
@Composable
fun LandscapePreview() {
    LandscapeScreen()
}