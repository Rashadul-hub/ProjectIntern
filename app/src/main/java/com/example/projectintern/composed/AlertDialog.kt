package com.example.projectintern.composed

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun AlertDialog() {

    Dialog(onDismissRequest = { /*TODO*/ }) {
        Surface(shape = RoundedCornerShape(14.dp), color = MaterialTheme.colors.background)
        {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "ERROR", style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colors.primary
                            )
                        )
//                        Icon(
//                            imageVector = Icons.Filled.Cancel,
//                            contentDescription = "",
//                            tint = Color.DarkGray,
//                            modifier = Modifier
//                                .clip(shape = CircleShape)
//                                .width(30.dp)
//                                .height(30.dp)
//                                .clickable {
//
//                                    ///Actions
//
//
//                                })

                    }
                    Spacer(modifier = Modifier.height(15.dp))



                    Text(
                        text = " Type your Error Message", style = TextStyle(
                            fontSize = 15.sp,
                            color = MaterialTheme.colors.error
                        )
                    )
                    Spacer(modifier = Modifier.height(15.dp))

                    Box(
                        modifier = Modifier.padding(
                            start = 30.dp,
                            top = 0.dp,
                            end = 30.dp,
                            bottom = 0.dp
                        )
                    ) {

                        CustomButton(buttonText = "Okay",onClick = {

                            //Action
                        })
                            




                    }

                }

            }


        }
    }
}

@Preview
@Composable
fun AlertDialogView() {
    AlertDialog()
}