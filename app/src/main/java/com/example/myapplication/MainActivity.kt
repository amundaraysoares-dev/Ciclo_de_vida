package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    var tiempoInicio =0L
    private companion object {
        private const val TAG = "Estado"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "alan",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        Log.d(TAG, "onCreate()")
    }
    override fun onStart() {
        super.onStart()


        tiempoInicio = System.currentTimeMillis()


        Log.d("Estado", "onStart")
    }


    override fun onResume() {
        super.onResume()


        tiempoInicio = System.currentTimeMillis()


        Log.d("Estado", "onResume")
    }


    override fun onPause() {
        super.onPause()


        val tiempoFinal = System.currentTimeMillis()
        val duracion = (tiempoFinal - tiempoInicio) /
                1000.0
        Log.d("Estado", "onPause: $duracion segundos en ejecucion")
    }


    override fun onStop() {
        super.onStop()


        val tiempoFinal = System.currentTimeMillis()
        val duracion = (tiempoFinal - tiempoInicio) /
                1000.0
        Log.d("Estado", "onStop: $duracion segundos")
    }


    override fun onDestroy() {
        super.onDestroy()


        val tiempoFinal = System.currentTimeMillis()
        val duracion = (tiempoFinal - tiempoInicio) /
                1000.0
        Log.d("Estado", "onDestroy: $duracion segundos")
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting(name = "Android")
    }
}