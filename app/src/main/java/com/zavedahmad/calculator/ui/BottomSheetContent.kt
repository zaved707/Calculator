package com.zavedahmad.calculator.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zavedahmad.calculator.data.MainPageViewModel

@Composable
fun BottomSheetContent(viewModel: MainPageViewModel){
    val historyList by viewModel.historyList.collectAsStateWithLifecycle()
    val expression by viewModel.expression.collectAsStateWithLifecycle()
    Column(
        Modifier
            .fillMaxHeight(0.65f)
            .padding(10.dp)
            .fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.height(50.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                "History",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 25.sp
            )
        }
        Spacer(modifier = Modifier.width(20.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.width(30.dp))

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(historyList) { item ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(1.dp)) {
                    Column (modifier = Modifier.padding(10.dp)){
                        Text(item.expression, fontSize = 30.sp,
                            modifier = Modifier.clickable(onClick = { viewModel.updateString(expression + item.expression)}))
                        Text(
                            item.answer,
                            modifier = Modifier.clickable(onClick = { viewModel.updateString(expression + item.answer)}),
                            fontSize = 20.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                HorizontalDivider()

            }
        }
    }

}