package com.example.loginscreenui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {

    val isImeVisible by rememberImeState()

    Gradientbox(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val animatedUpperSectionRatio by animateFloatAsState(
                targetValue = if (isImeVisible) 0f else 0.35f,
                label = ""
            )

            AnimatedVisibility(visible = !isImeVisible, enter = fadeIn(), exit = fadeOut()) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(animatedUpperSectionRatio),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "Welcome to my app",
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.White
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                if (isSmallScreenHeight()) Spacer(modifier = Modifier.fillMaxSize(0.0f))
                else Spacer(modifier = Modifier.fillMaxSize(0.1f))

                Text(
                    text = "Log in",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.Black
                )
                if (isSmallScreenHeight()) Spacer(modifier = Modifier.fillMaxSize(0.0f))
                else Spacer(modifier = Modifier.fillMaxSize(0.1f))

                MyTextField(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    label = "Username",
                    keyboardOptions = KeyboardOptions(),
                    keyboardActions = KeyboardActions(),
                    trailingIcon = Icons.Default.AccountCircle
                )
                Spacer(modifier = Modifier.height(20.dp))

                MyTextField(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    label = "Password",
                    keyboardOptions = KeyboardOptions(),
                    keyboardActions = KeyboardActions(),
                    trailingIcon = Icons.Default.Lock
                )
                if (isImeVisible) {

                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.fillMaxWidth().padding(top = 20.dp).padding(horizontal = 16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xC914469B),
                            contentColor = Color.White
                        )
                    ) {

                        Text(
                            text = "Log in",
                            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight(500))
                        )

                    }

                } else {

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp), contentAlignment = Alignment.CenterStart
                    ) {


                        Button(
                            onClick = { /*TODO*/ }, //navigate to register screen
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xC914469B),
                                contentColor = Color.White
                            )
                        ) {

                            Text(
                                text = "Log in",
                                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight(500))
                            )

                        }


                    }
                }


            }

        }

    }
}