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
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
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
import com.example.projectintern.ui.theme.OnPrimaryLight


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    Scaffold(
        topBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(), elevation = 16.dp
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(values)
                .background(color = OnPrimaryLight) //White Color


        ) {

            //Body Section
            LoginContent()

        }


    }

}


@Composable
fun LoginContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Spacer(modifier = Modifier.height(25.dp))

        //Logo Section
        Image(
            painter = painterResource(id = R.drawable.kotha_app_logo),
            contentDescription = "app logo",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(40.23196.dp)
                .height(35.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))
        TitleSection()
        Spacer(modifier = Modifier.height(7.dp))
        ExampleText()
        Spacer(modifier = Modifier.height(22.dp))
        PhoneNumberInput()
        Spacer(modifier = Modifier.height(40.dp))
        SendOTPButton()
        Spacer(modifier = Modifier.height(46.dp))
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
            .fillMaxWidth()
            .height(19.dp),
        fontWeight = FontWeight(700),
        fontFamily = FontFamily(Font(R.font.inter_font))
    )
}

@Composable
fun ExampleText() {
    Text(
        text = "Example: 01713048764",
        textAlign = TextAlign.Center,
        fontSize = 14.sp,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier
            .fillMaxWidth()
            .alpha(0.8f),
        color = Color(
            red = 0.21568627655506134f,
            green = 0.27843138575553894f,
            blue = 0.30980393290519714f,
            alpha = 0.800000011920929f
        ),
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Normal,
    )
}


@Composable
fun PhoneNumberInput() {
    OutlinedTextField(
        value = "01715011222",
        onValueChange = { /* Handle value change here */ },
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
            fontFamily = FontFamily(Font(R.font.inter_font))
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
            .fillMaxWidth()
            .alpha(1f),
        color = Color(0f, 0.5803921818733215f, 0.49803921580314636f, 1f),
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
    )
}


@Preview
@Composable
fun Log() {
    LoginScreen()
}


//
//@Preview(showBackground = true)
//@Composable
//fun DefaultScreenView() {
//    Body()
//}