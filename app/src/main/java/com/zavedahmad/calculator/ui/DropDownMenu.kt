package com.zavedahmad.calculator.ui

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zavedahmad.calculator.data.MainPageViewModel

@Composable
fun DropDownMenuMain(viewModel: MainPageViewModel) {
    var expanded by remember { mutableStateOf(false) }
    IconButton(onClick = { expanded = !expanded }) {
        Icon(
            Icons.Default.MoreVert,
            contentDescription = "menu",
            Modifier.size(50.dp)
        )
    }
    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = !expanded }) {
        DropdownMenuItem(
            onClick = {
                expanded = !expanded
                viewModel.setThemePreferences("system")

            },
            text = { Text("system") })
        DropdownMenuItem(onClick = {
            expanded = !expanded
            viewModel.setThemePreferences("dark")

        }, text = { Text("dark") })
        DropdownMenuItem(
            onClick = {
                expanded = !expanded
                viewModel.setThemePreferences("light")

            },
            text = { Text("light") })
    }
}