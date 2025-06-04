package com.zavedahmad.calculator.ui


import androidx.compose.foundation.gestures.detectTapGestures

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.size

import androidx.compose.material.icons.Icons

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp

import com.zavedahmad.calculator.data.MainPageViewModel

import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.BottomSheetScaffold

import androidx.compose.material3.rememberBottomSheetScaffoldState

import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.input.pointer.pointerInput

import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(modifier: Modifier = Modifier, viewModel: MainPageViewModel) {

    val coroutineScope = rememberCoroutineScope()

    val scaffoldState = rememberBottomSheetScaffoldState(

    )

    BottomSheetScaffold(modifier = Modifier.pointerInput(Unit) {
        detectTapGestures(onTap = {
            coroutineScope.launch {
                if (scaffoldState.bottomSheetState.isVisible) {
                    scaffoldState.bottomSheetState.partialExpand()
                }
            }
        })
    }, scaffoldState = scaffoldState, sheetPeekHeight = 0.dp, sheetDragHandle = {
        IconButton(onClick = { coroutineScope.launch { scaffoldState.bottomSheetState.partialExpand() } }) {
            Icon(
                Icons.Default.Close, contentDescription = "history", Modifier.size(50.dp)
            )
        }
    }, sheetSwipeEnabled = false, sheetContent = {
        BottomSheetContent(viewModel)
    }) {

        Column(modifier = modifier) {
            DisplayScreen(scaffoldState, viewModel)
            Spacer(modifier = Modifier.height(20.dp))
            Buttons(viewModel)

        }
    }
}