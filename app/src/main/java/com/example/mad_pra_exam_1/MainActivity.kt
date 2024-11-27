package com.example.mad_pra_exam_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mad_pra_exam_1.ui.theme.MAD_Pra_Exam1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MAD_Pra_Exam1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    EventDetailsScreen()
                }
            }
        }
    }
}
