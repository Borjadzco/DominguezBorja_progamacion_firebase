package com.example.dominguezborja_progamacion_firebase.Pantalla

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dominguezborja_progamacion_firebase.ui.theme.DominguezBorja_progamacion_firebaseTheme

@Composable
fun Home(){
    Column (horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center){
        Text(text = "Login", fontSize = 50.sp)
        Spacer(modifier = Modifier.padding(10.dp))
        Login()
        RegistroEntrar()
    }
}

@Composable
fun Login(){
    Column(modifier = Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(value = "",
            onValueChange = {},
            singleLine = true, label = { Text("Email") },
            modifier = Modifier.padding(10.dp)
                .fillMaxWidth()
        )
        TextField(value = "",
            onValueChange = {},
            singleLine = true, label = { Text("Contraseña") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.padding(10.dp)
                .fillMaxWidth()
            )
        Button(onClick = {}, modifier = Modifier.fillMaxWidth()
            .padding(10.dp)) {
            Text("Entrar")
        }
    }
}
@Composable
fun RegistroEntrar(){
    Row {
        Text("¿No tienes Cuenta? ")
        Text(text = "Registrate", )
    }
}

@Preview(showBackground = true)
@Composable
fun verHome(){
    DominguezBorja_progamacion_firebaseTheme {
        Home()
    }
}