package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ejercicio2()
        }
    }
}


@Preview
@Composable
fun Ejercicio2() {

    var text by remember { mutableStateOf("") }
    var lista = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .padding(36.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,


        ) {

        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Nombre") }
        )

        Button(onClick = {
            lista.add(text)
            text = ""

        }) {
            Text("Guardar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()

        ) {

            Text(

                text = "Listado de nombres \n y posicion de la lista",
                fontSize = 18.sp

            )
            Button(onClick = {
                lista.clear()
                text = ""

            }) {
                Text("Limpiar")
            }

        }

        Column(
            modifier = Modifier
                .height(200.dp)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            LazyColumn {
                itemsIndexed(lista.toList()) { index, item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = item
                        )
                        Text(
                            text = (index + 1).toString()
                        )
                    }
                }
            }
        }




    }
}
