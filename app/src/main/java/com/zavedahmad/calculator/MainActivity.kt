package com.zavedahmad.calculator


import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zavedahmad.calculator.data.MainPageViewModel
import com.zavedahmad.calculator.ui.MainPage
import com.zavedahmad.calculator.ui.theme.CalculatorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainPageViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)


        setContent {
            val theme by viewModel.theme.collectAsStateWithLifecycle()

            if (theme == "") {
                CalculatorTheme("system") {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        Box(
                            modifier = Modifier.fillMaxSize().padding(innerPadding),
                            contentAlignment = Alignment.Center
                        ) {

                        }
                    }
                }
            } else {
                CalculatorTheme(theme =theme) {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->


                        MainPage(


                            modifier = Modifier.padding(innerPadding), viewModel
                        )
                    }
                }
            }
        }
    }
}

