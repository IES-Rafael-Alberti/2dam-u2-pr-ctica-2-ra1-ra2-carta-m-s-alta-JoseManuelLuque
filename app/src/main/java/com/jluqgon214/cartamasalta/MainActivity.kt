package com.jluqgon214.cartamasalta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jluqgon214.cartamasalta.ui.theme.CartaMasAltaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CartaMasAltaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    CartaMasAlta()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartaMasAlta() {
    var cartaActual by rememberSaveable { mutableStateOf(Carta(Naipes.As, Palos.Corazones, 1, 11, R.drawable.reverse)) }
    Column(
        Modifier
            .fillMaxSize()
            .size(250.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.reverse),
            contentDescription = "Nose",
            Modifier.size(250.dp)
        )
    }

    Row(
        Modifier
            .fillMaxSize()
            .padding(bottom = 20.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(onClick = { cartaActual = Baraja.dameCarta() }, Modifier.padding(10.dp)) {
            Text(text = "Dame Carta")
        }
        Button(onClick = {
            Baraja.crearBaraja()
            Baraja.barajar()
        }, Modifier.padding(10.dp)) {
            Text(text = "Reiniciar")
        }
    }
}