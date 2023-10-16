package com.example.projectintern.screens

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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpScreen() {


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
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Back Icon",
                            Modifier
                                .size(32.dp)
                                .padding(1.dp)
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
        } else {
            // In portrait mode, we  use this existing layout
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(values)
                    .background(color = OnPrimaryLight) // White Color
            ) {

                // Body Section
                OtpContents(dimensions)
            }
        }
    }
}



@Composable
fun OtpContents(dimensions: Dimensions) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensions.medium) // Adjust padding based on window size
            .wrapContentSize(Alignment.Center)


    ) {

        Spacer(modifier = Modifier.height(dimensions.medium))

        // Logo Section
        Image(
            painter = painterResource(id = R.drawable.kotha_app_logo),
            contentDescription = "app logo",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(40.dp)
        )

        Spacer(modifier = Modifier.height(dimensions.smallMedium))
        VerifySection()
        Spacer(modifier = Modifier.height(dimensions.medium))
        SMSInformationSection()
        Spacer(modifier = Modifier.height(dimensions.medium))
        InputOTPNumber()
        Spacer(modifier = Modifier.height(dimensions.mediumLarge))
        ConfirmButton()
        Spacer(modifier = Modifier.height(dimensions.mediumLarge))
        DummyText()
    }
}


@Composable
fun VerifySection() {
    val text = "OTP Verification"

    Text(
        text = text,
        textAlign = TextAlign.Center,
        fontSize = 16.sp,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        fontWeight = FontWeight(700),
        color = Color(0xFF37474F),
        fontFamily = FontFamily(Font(R.font.inter_bold))
    )
}


@Composable
fun SMSInformationSection() {
    Text(
        text = "A SMS is sent to the number: 017150112222 ",
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
fun InputOTPNumber() {
    var phoneNumber by remember {
        mutableStateOf("")
    }

    Box(
        contentAlignment = Alignment.Center, // Center the content horizontally and vertically
        modifier = Modifier
            .fillMaxWidth() // Take the full available width
            .padding(horizontal = 16.dp) // Add horizontal padding
            .padding(vertical = 6.dp)
    ) {
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            modifier = Modifier
                .fillMaxWidth() // Take the full available width within the Box
                .widthIn(max = 333.dp) // maximum width
                .border(width = 1.dp, color = Color(0xFF979797)),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
            textStyle = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
                textAlign = TextAlign.Center,
                letterSpacing = 10.sp,
                fontFamily = FontFamily(Font(R.font.inter_semi_bold))
            )
        )
    }
}


@Composable
fun ConfirmButton() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        CustomOTPButton(buttonText = "Confirm", onClick = {})
    }
}

@Composable
fun DummyText() {
    Text(
        text = "Wait and Press Resend if no OTP arrives. \nContact Support info@kotha.app ",
        textAlign = TextAlign.Center,
        fontSize = 16.sp,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier
            .fillMaxWidth() // Take the full available width
            .wrapContentHeight(), // Wrap the content for height
        color = Color(0xCC37474F),
        fontWeight = FontWeight(500),
        fontFamily = FontFamily(Font(R.font.inter_medium))
    )
}


@Preview
@Composable
fun OtpPreview() {
    OtpScreen()
}