package com.example.projectintern.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectintern.R
import com.example.projectintern.composed.CustomOTPButton
import com.example.projectintern.composed.SignInTitle
import com.example.projectintern.model.Dimensions
import com.example.projectintern.model.WindowSize
import com.example.projectintern.model.compactDimensions
import com.example.projectintern.model.largeDimensions
import com.example.projectintern.model.mediumDimensions
import com.example.projectintern.model.rememberWindowSizeClass
import com.example.projectintern.model.smallDimensions
import com.example.projectintern.ui.theme.OnPrimaryLight


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {

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
                elevation = dimensions.small
            ) {
                CenterAlignedTopAppBar(navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Back Icon",
                            Modifier.size(32.dp)
                        )
                    }
                }, title = {
                    SignInTitle(text = "Sign in")
                })
            }
        },
    ) { values ->
        // If in landscape mode, wrap the content in a scrollable LazyColumn
        if (isLandscape) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    Box(
                        modifier = Modifier
                            .padding(values)
                            .background(color = OnPrimaryLight)
                    ) {
                        // Body Section
                        LoginContent(dimensions)
                    }
                }
            }
        } else{
            // In portrait mode, we  use this existing layout
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(values)
                    .background(color = OnPrimaryLight) // White Color
            ) {

                // Body Section
                LoginContent(dimensions)
            }
        }
    }
}

@Composable
fun LoginContent(dimensions: Dimensions) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensions.medium) // Adjust padding based on window size
    ) {

        Spacer(modifier = Modifier.height(dimensions.small))

        // Logo Section
        Image(
            painter = painterResource(id = R.drawable.kotha_app_logo),
            contentDescription = "app logo",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(35.dp)
        )

        Spacer(modifier = Modifier.height(dimensions.smallMedium))
        TitleSection()
        Spacer(modifier = Modifier.height(dimensions.medium))
        ExampleText()
        Spacer(modifier = Modifier.height(dimensions.medium))
        PhoneNumberInput()
        Spacer(modifier = Modifier.height(dimensions.large))
        SendOTPButton()
        Spacer(modifier = Modifier.height(dimensions.mediumLarge))
        RegisterLink()
    }
}



@Composable
fun TitleSection() {
    Text(
        text = "Type your 11 digit Bangladeshi Number",
        textAlign = TextAlign.Center,
        fontSize = 16.sp,
        modifier = Modifier
            .fillMaxWidth() // Take the full available width
            .wrapContentHeight(), // Wrap the content for height
        fontWeight = FontWeight(700),
        color = Color(0xFF37474F),
        fontFamily = FontFamily(Font(R.font.inter_bold))
    )
}

@Composable
fun ExampleText() {
    Text(
        text = "Example: 01713048764",
        textAlign = TextAlign.Center,
        fontSize = 14.sp,
        modifier = Modifier
            .fillMaxWidth() //Take the full available width
            .wrapContentHeight(),// Wrap the content for height
        color = Color(0xCC37474F),
        fontWeight = FontWeight(600),
        fontFamily = FontFamily(Font(R.font.inter_semi_bold))
    )
}


@Composable
fun PhoneNumberInput() {
    var phoneNumber by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = phoneNumber,
        onValueChange = { phoneNumber= it },  // Update the mutable state with the new input
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .border(width = 1.dp, color = Color(0xFF979797)),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),


        textStyle = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF000000),
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.inter_semi_bold))
        )

    )
}


@Composable
fun SendOTPButton() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), contentAlignment = Alignment.Center
    ) {
        CustomOTPButton(buttonText = "Send OTP", onClick = {})
    }
}

@Composable
fun RegisterLink() {
    Text(
        text = "Don’t have a Bangladeshi Number? Tap here",
        textAlign = TextAlign.Center,
        fontSize = 16.sp,
        textDecoration = TextDecoration.Underline,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier
            .fillMaxWidth() // Take the full available width
            .wrapContentHeight(), // Wrap the content for height
        color = Color(0xFF00947F),
        fontWeight = FontWeight(500),
        fontFamily = FontFamily(Font(R.font.inter_medium))
    )
}


@Preview
@Composable
fun Log() {
    LoginScreen()
}

