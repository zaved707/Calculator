package com.zavedahmad.calculator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Backspace
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainPage(modifier: Modifier = Modifier) {
    val numberColor = MaterialTheme.colorScheme.surfaceBright
    val actionsColor = MaterialTheme.colorScheme.secondaryContainer
    val buttonRoundness = 30.dp
    val buttonWidth = 90
    val buttonHeight = 90
    val fontDivider = 3
    val fontDividerNumber = 2
    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxHeight(0.3f)
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(20.dp)
                )
                .background(MaterialTheme.colorScheme.primaryContainer)

        ) {}
        Spacer(modifier = Modifier.height(20.dp))
        Column(verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxSize()) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {}, shape = RoundedCornerShape(buttonRoundness),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier
                        .width(buttonWidth.dp)
                        .height(buttonHeight.dp)
                ) {
                    Text(
                        "AC", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        softWrap = false,
                        fontSize = (buttonHeight / fontDivider).sp
                    )
                }
                Button(
                    onClick = {}, shape = RoundedCornerShape(buttonRoundness),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = actionsColor,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier
                        .width(buttonWidth.dp)
                        .height(buttonHeight.dp)
                ) {
                    Text(
                        "()", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDivider).sp
                    )
                }
                Button(
                    onClick = {}, shape = RoundedCornerShape(buttonRoundness),colors = ButtonDefaults.buttonColors(
                        containerColor = actionsColor,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier
                        .width(buttonWidth.dp)
                        .height(buttonHeight.dp)
                ) {
                    Text(
                        "^", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDivider).sp
                    )
                }
                Button(
                    onClick = {}, shape = RoundedCornerShape(buttonRoundness),colors = ButtonDefaults.buttonColors(
                        containerColor = actionsColor,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier
                        .width(buttonWidth.dp)
                        .height(buttonHeight.dp)
                ) {
                    Text(
                        "/", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDivider).sp
                    )
                }

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {}, shape = RoundedCornerShape(buttonRoundness),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = numberColor,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier
                        .width(buttonWidth.dp)
                        .height(buttonHeight.dp)
                ) {
                    Text(
                        "7", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDividerNumber).sp
                    )
                }
                Button(
                    onClick = {}, shape = RoundedCornerShape(buttonRoundness),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = numberColor,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier
                        .width(buttonWidth.dp)
                        .height(buttonHeight.dp)
                ) {
                    Text(
                        "8", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDividerNumber).sp
                    )
                }
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(buttonRoundness),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = numberColor,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier
                        .width(buttonWidth.dp)
                        .height(buttonHeight.dp)
                ) {
                    Text(
                        "9", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDividerNumber).sp
                    )
                }
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(buttonRoundness),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = actionsColor,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier
                        .width(buttonWidth.dp)
                        .height(buttonHeight.dp)
                ) {
                    Text(
                        "x", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDivider).sp
                    )
                }

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {}, shape = RoundedCornerShape(buttonRoundness),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = numberColor,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier
                        .width(buttonWidth.dp)
                        .height(buttonHeight.dp)
                ) {
                    Text(
                        "4", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDividerNumber).sp
                    )
                }
                Button(
                    onClick = {}, shape = RoundedCornerShape(buttonRoundness),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = numberColor,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier
                        .width(buttonWidth.dp)
                        .height(buttonHeight.dp)
                ) {
                    Text(
                        "5", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDividerNumber).sp
                    )
                }
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(buttonRoundness),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = numberColor,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier
                        .width(buttonWidth.dp)
                        .height(buttonHeight.dp)
                ) {
                    Text(
                        "6", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDividerNumber).sp
                    )
                }
                Button(
                    onClick = {}, shape = RoundedCornerShape(buttonRoundness),colors = ButtonDefaults.buttonColors(
                        containerColor = actionsColor,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier
                        .width(buttonWidth.dp)
                        .height(buttonHeight.dp)
                ) {
                    Text(
                        "-", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDivider).sp
                    )
                }

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {}, shape = RoundedCornerShape(buttonRoundness),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = numberColor,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier
                        .width(buttonWidth.dp)
                        .height(buttonHeight.dp)
                ) {
                    Text(
                        "1", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDividerNumber).sp
                    )
                }
                Button(
                    onClick = {}, shape = RoundedCornerShape(buttonRoundness),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = numberColor,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier
                        .width(buttonWidth.dp)
                        .height(buttonHeight.dp)
                ) {
                    Text(
                        "2", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDividerNumber).sp
                    )
                }
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(buttonRoundness),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = numberColor,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier
                        .width(buttonWidth.dp)
                        .height(buttonHeight.dp)
                ) {
                    Text(
                        "3", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDividerNumber).sp
                    )
                }
                Button(
                    onClick = {}, shape = RoundedCornerShape(buttonRoundness),colors = ButtonDefaults.buttonColors(
                        containerColor = actionsColor,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier
                        .width(buttonWidth.dp)
                        .height(buttonHeight.dp)
                ) {
                    Text(
                        "+", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDivider).sp
                    )
                }

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {}, shape = RoundedCornerShape(buttonRoundness),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = numberColor,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier
                        .width(buttonWidth.dp)
                        .height(buttonHeight.dp)
                ) {
                    Text(
                        "0", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDividerNumber).sp
                    )
                }
                Button(
                    onClick = {}, shape = RoundedCornerShape(buttonRoundness),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = numberColor,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier
                        .width(buttonWidth.dp)
                        .height(buttonHeight.dp)
                ) {
                    Text(
                        ".", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDivider).sp
                    )
                }
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(buttonRoundness),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = numberColor,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier
                        .width(buttonWidth.dp)
                        .height(buttonHeight.dp)
                ) {
                    Icon(Icons.Outlined.Backspace, contentDescription = "fuck this shit", modifier = Modifier.fillMaxSize(0.8f))
                }
                Button(
                    onClick = {}, shape = RoundedCornerShape(buttonRoundness),colors = ButtonDefaults.buttonColors(
                        containerColor = actionsColor,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier
                        .width(buttonWidth.dp)
                        .height(buttonHeight.dp)
                ) {
                    Text(
                        "=", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDivider).sp
                    )
                }

            }
        }

    }
}