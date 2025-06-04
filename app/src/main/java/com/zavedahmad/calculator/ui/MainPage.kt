package com.zavedahmad.calculator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Backspace
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.outlined.Backspace
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zavedahmad.calculator.data.MainPageViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.rememberModalBottomSheetState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(modifier: Modifier = Modifier, viewModel: MainPageViewModel) {

    val scrollState = rememberScrollState()
    val expression by viewModel.expression.collectAsStateWithLifecycle()
    LaunchedEffect(expression) {
        scrollState.scrollTo(scrollState.maxValue)
    }
    val historyList by viewModel.historyList.collectAsStateWithLifecycle()
    var showBottomSheet by remember { mutableStateOf(false) }
    val result by viewModel.result.collectAsStateWithLifecycle()
    val numberColor = MaterialTheme.colorScheme.surfaceBright
    val actionsColor = MaterialTheme.colorScheme.secondaryContainer
    val buttonRoundness = 30.dp
    val buttonWidth = 90
    val buttonHeight = 90
    val fontDivider = 3
    val fontDividerNumber = 2
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true, )

    if (showBottomSheet) {
        ModalBottomSheet(
            
            onDismissRequest = { showBottomSheet = false },
            scrimColor = Color.Transparent
        ) { Column(Modifier.fillMaxHeight(0.65f).padding(10.dp).fillMaxWidth()) {
            Text("History", textAlign = TextAlign.Center,modifier= Modifier.fillMaxWidth(), fontSize = 25.sp)
            Spacer(modifier = Modifier.width(20.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.width(30.dp))

            LazyColumn (modifier = Modifier.fillMaxWidth()){ items(historyList) { item -> Text(item.expression, fontSize = 30.sp)
            Text(item.answer, fontSize = 20.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)} } } }
    }
    Column(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxHeight(0.3f)
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(20.dp)
                )
                .background(MaterialTheme.colorScheme.primaryContainer),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End

        ) {
            IconButton(onClick = { showBottomSheet = true }) {
                Icon(
                    Icons.Default.History,
                    contentDescription = "history"
                )
            }

            Text(
                expression, fontSize = 50.sp, style = TextStyle(lineHeight = 50.sp),
                maxLines = 1, // Ensures single line
                overflow = TextOverflow.Clip, // Prevents wrapping or ellipsis
                modifier = Modifier
                    .horizontalScroll(scrollState) // Enables horizontal scrolling
            )
            Text(result)

        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxSize()) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { viewModel.updateString("") },
                    shape = RoundedCornerShape(buttonRoundness),
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
                    onClick = {
                        viewModel.updateString(expression + "(")
                    },
                    shape = RoundedCornerShape(buttonRoundness),
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = actionsColor,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier
                        .width((buttonWidth / 2).dp)
                        .height(buttonHeight.dp)
                ) {
                    Text(
                        "(", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDivider).sp
                    )
                }
                Button(
                    onClick = { viewModel.updateString(expression + ")") },
                    shape = RoundedCornerShape(buttonRoundness),
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = actionsColor,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier
                        .width((buttonWidth / 2).dp)
                        .height(buttonHeight.dp)
                ) {
                    Text(
                        ")", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDivider).sp
                    )
                }
                Button(
                    onClick = { viewModel.updateString(expression + "^") },
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
                        "^", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDivider).sp
                    )
                }
                Button(
                    onClick = { viewModel.updateString(expression + "/") },
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
                    onClick = { viewModel.updateString(expression + "7") },
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
                        "7", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDividerNumber).sp
                    )
                }
                Button(
                    onClick = { viewModel.updateString(expression + "8") },
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
                        "8", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDividerNumber).sp
                    )
                }
                Button(
                    onClick = { viewModel.updateString(expression + "9") },
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
                    onClick = { viewModel.updateString(expression + "*") },
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
                    onClick = { viewModel.updateString(expression + "4") },
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
                        "4", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDividerNumber).sp
                    )
                }
                Button(
                    onClick = { viewModel.updateString(expression + "5") },
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
                        "5", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDividerNumber).sp
                    )
                }
                Button(
                    onClick = { viewModel.updateString(expression + "6") },
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
                    onClick = { viewModel.updateString(expression + "-") },
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
                    onClick = { viewModel.updateString(expression + "1") },
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
                        "1", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDividerNumber).sp
                    )
                }
                Button(
                    onClick = { viewModel.updateString(expression + "2") },
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
                        "2", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDividerNumber).sp
                    )
                }
                Button(
                    onClick = { viewModel.updateString(expression + "3") },
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
                    onClick = { viewModel.updateString(expression + "+") },
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
                    onClick = { viewModel.updateString(expression + "0") },
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
                        "0", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDividerNumber).sp
                    )
                }
                Button(
                    onClick = { viewModel.updateString(expression + ".") },
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
                        ".", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDivider).sp
                    )
                }
                Button(
                    onClick = { viewModel.backspace() },
                    shape = RoundedCornerShape(buttonRoundness),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = numberColor,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier
                        .width(buttonWidth.dp)
                        .height(buttonHeight.dp)
                ) {
                    Icon(
                        Icons.AutoMirrored.Outlined.Backspace,
                        contentDescription = "fuck this shit",
                        modifier = Modifier.fillMaxSize(0.8f)
                    )
                }
                Button(
                    onClick = { viewModel.equal() },
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
                        "=", modifier = Modifier.fillMaxWidth(), // Text fills button width
                        textAlign = TextAlign.Center,
                        fontSize = (buttonHeight / fontDivider).sp
                    )
                }

            }
        }

    }
}