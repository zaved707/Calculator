package com.zavedahmad.calculator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zavedahmad.calculator.data.MainPageViewModel
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun DisplayScreen(scaffoldState: BottomSheetScaffoldState, viewModel: MainPageViewModel) {
    val result by viewModel.result.collectAsStateWithLifecycle()

    val scrollState = rememberScrollState()
    val expression by viewModel.expression.collectAsStateWithLifecycle()
    val coroutineScope = rememberCoroutineScope()


    LaunchedEffect(expression) {
        scrollState.scrollTo(scrollState.maxValue)
    }
    Column(
        modifier = Modifier
            .fillMaxHeight(0.3f)
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(20.dp)
            )
            .background(MaterialTheme.colorScheme.primaryContainer),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.End

    ) {

        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
            Row {
            DropDownMenuMain(viewModel)
                }

            IconButton(onClick = { coroutineScope.launch { scaffoldState.bottomSheetState.expand() } }) {
                Icon(
                    Icons.Default.History,
                    contentDescription = "history",
                    Modifier.size(50.dp)
                )
            }
        }

        Spacer(Modifier.height(20.dp))

        Text(
            expression, fontSize = 50.sp, style = TextStyle(lineHeight = 50.sp),
            maxLines = 1, // Ensures single line
            overflow = TextOverflow.Clip, // Prevents wrapping or ellipsis
            modifier = Modifier
                .horizontalScroll(scrollState) // Enables horizontal scrolling
        )
        Text(result)

    }
}