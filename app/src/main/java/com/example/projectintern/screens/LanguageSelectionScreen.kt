package com.example.projectintern.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.projectintern.R
import com.example.projectintern.composed.TitleText
import com.example.projectintern.model.Dimensions
import com.example.projectintern.model.WindowSize
import com.example.projectintern.model.compactDimensions
import com.example.projectintern.model.largeDimensions
import com.example.projectintern.model.mediumDimensions
import com.example.projectintern.model.rememberWindowSizeClass
import com.example.projectintern.model.smallDimensions

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageSelectionScreen(
    navController: NavController,

    ) {


    val windowSize = rememberWindowSizeClass()
    val dimensions = when (windowSize.width) {
        is WindowSize.Small -> smallDimensions
        is WindowSize.Compact -> compactDimensions
        is WindowSize.Medium -> mediumDimensions
        is WindowSize.Large -> largeDimensions
    }

    // Determine whether the device is in landscape orientation
    val isLandscape = windowSize.width is WindowSize.Large

    Scaffold(
        topBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                elevation = dimensions.large
            ) {
                CenterAlignedTopAppBar(navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate("") //Back to OTP Screen
                    }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Back Icon",
                            Modifier
                                .size(32.dp)
                                .padding(1.dp)
                        )
                    }
                }, title = {
                    TitleText(text = " ")
                })
            }
        },
    ) {
        if (isLandscape) {
            LandscapeLayout(dimensions)
        } else {
            LanguageContents(dimensions)
        }

    }

}

@Composable
fun LandscapeLayout(dimensions: Dimensions) {
    LazyColumn {
        item {
            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                LanguageContents(dimensions)
                SelectOptions()
                Spacer(modifier = Modifier.height(dimensions.large))

            }
        }
    }
}

@Composable
fun LanguageContents(dimensions: Dimensions) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.height(dimensions.small))


        // Logo Section
        Image(
            painter = painterResource(id = R.drawable.kotha_app_logo_large),
            contentDescription = "app logo",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(90.dp)
        )
        Spacer(modifier = Modifier.weight(1f))

        SelectionText(dimensions)

        Spacer(modifier = Modifier.height(dimensions.small))

        SelectOptions()

        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun SelectionText(dimensions: Dimensions) {

    Column(
        modifier = Modifier.padding(horizontal = 10.dp)
    ) {

        Text(
            text = stringResource(id = R.string.select_your_language),
            textAlign = TextAlign.Start,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .alpha(1f),
            color = Color(0xFF37474F),
            fontWeight = FontWeight(500),
            fontFamily = FontFamily(Font(R.font.inter_medium))
        )

        Spacer(modifier = Modifier.height(dimensions.small))

        Text(
            text = stringResource(id = R.string.select_your_interface),
            textAlign = TextAlign.Start,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            color = Color(0x83455154),
            fontWeight = FontWeight(500),
            fontFamily = FontFamily(Font(R.font.inter_medium))
        )
        Spacer(modifier = Modifier.height(dimensions.small))

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color(0x1E455154))
        )

    }

}


@Composable
fun SelectOptions() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        ClickableOption("English (EN)")

        Spacer(modifier = Modifier.width(5.dp)) // Add a Spacer to control the spacing

        ClickableOption("বাংলা (BN)")
    }
}

@Composable
fun ClickableOption(optionText: String) {
    var isSelected by remember { mutableStateOf(false) }

    Spacer(modifier = Modifier.width(10.dp)) // Add padding from the start


    Box(
        modifier = Modifier
            .clickable {
                isSelected = !isSelected
            }
            .width(80.dp)
            .height(28.dp)
            .clip(RoundedCornerShape(15.dp))
            .border(1.dp, Color.Transparent, RoundedCornerShape(15.dp))
            .background(if (isSelected) Color(0xFF00B99F) else Color.LightGray)

    ) {
        Text(
            text = optionText,
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
                .wrapContentSize(Alignment.Center), // Align text vertically and horizontally in the center
            fontSize = 10.sp,
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontFamily = FontFamily(Font(R.font.inter_medium))
        )
    }
}

@Preview
@Composable
fun LanguageView() {
    val dummyNavController = rememberNavController() // Create a dummy NavController
    LanguageSelectionScreen(navController = dummyNavController)
}