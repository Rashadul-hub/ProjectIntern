package com.example.projectintern.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.projectintern.composed.ThemeSwitch
import com.example.projectintern.ui.theme.AppTheme


@Composable
fun PortraitScreen() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                //Demo
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "img1",
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(
                                bottomEnd = AppTheme.dimens.medium,
                                bottomStart = AppTheme.dimens.medium
                            )
                        )
                        .fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )

                //TextHeadLine(text = "Welcome", color = Color.White)

            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(AppTheme.dimens.large)
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
                ThemeSwitch() //Theme Switch Mode
            }
//            ComposableButton()
        }

}

@Preview
@Composable
fun PortraitPreview() {
    PortraitScreen()
}