package com.example.pc02_moviles_22200125_22200111

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.pc02_moviles_22200125_22200111.navigation.AppNavGraph
import com.example.pc02_moviles_22200125_22200111.ui.theme.PC02_MOVILES_2220012522200111Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint // <-- ¡Añadido para Hilt!
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PC02_MOVILES_2220012522200111Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Llama a tu grafo de navegación aquí
                    AppNavGraph()
                }
            }
        }
    }
}
