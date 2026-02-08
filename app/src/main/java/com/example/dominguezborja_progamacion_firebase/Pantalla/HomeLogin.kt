package com.example.dominguezborja_progamacion_firebase.Pantalla

import android.webkit.RenderProcessGoneDetail
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dominguezborja_progamacion_firebase.Componentes.UiState.UiStateTienda
import com.example.dominguezborja_progamacion_firebase.Componentes.UiState.ViewModelTienda
import com.example.dominguezborja_progamacion_firebase.ui.theme.DominguezBorja_progamacion_firebaseTheme

@Composable
fun Home( viewModelTienda: ViewModelTienda = viewModel(), navigationToDetail:()-> Unit){
    val uiState by viewModelTienda.uistate.collectAsState()
    Column (horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center){
        Text(text = "Login", fontSize = 50.sp)
        Spacer(modifier = Modifier.padding(10.dp))
        Login(viewModelTienda, uiState)
        RegistroEntrar(navigationToDetail)
    }
}

@Composable
fun Login(viewModel: ViewModelTienda, uiState: UiStateTienda){
    Column(modifier = Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(value =uiState.login,
            onValueChange = {},
            singleLine = true, label = { Text("Email") },
            modifier = Modifier.padding(10.dp)
                .fillMaxWidth()
        )
        TextField(value = uiState.contraseña,
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
fun RegistroEntrar(navigationToDetail:()-> Unit){
    Row {
        Text("¿No tienes Cuenta? ")
        Text(text = "Registrate", modifier = Modifier.clickable{
            navigationToDetail()
        },
            color = Color(0xFF0000ff),
            textDecoration = TextDecoration.Underline
        )
    }
}

@Preview(showBackground = true)
@Composable
fun verHome(){
    DominguezBorja_progamacion_firebaseTheme {
        Home{}
    }
}