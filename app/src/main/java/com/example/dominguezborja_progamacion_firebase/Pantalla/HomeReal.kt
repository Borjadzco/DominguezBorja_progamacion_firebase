package com.example.dominguezborja_progamacion_firebase.Pantalla

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dominguezborja_progamacion_firebase.Componentes.UiState.UiStateTienda
import com.example.dominguezborja_progamacion_firebase.Componentes.UiState.ViewModelTienda
import com.example.dominguezborja_progamacion_firebase.ui.theme.DominguezBorja_progamacion_firebaseTheme

@Composable
fun RealHome(viewModelTienda: ViewModelTienda= viewModel(), onExitHome: () -> Unit){
    val uiState by viewModelTienda.uistate.collectAsState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center) {

        Cabecera(uiState, onExitHome)
        Spacer(modifier = Modifier.padding(25.dp))
        Cuerpo()
    }
}
@Composable
fun Cabecera(uiState: UiStateTienda, onExitHome: () -> Unit){
    Row(modifier = Modifier.fillMaxWidth()) {
        lateinit var email: String
        if (uiState.login.isNotEmpty()){
            var email = uiState.login
            Text("Bienvenido ${email}", modifier = Modifier.weight(1f))
        }else{
            var email = uiState.loginRegistro
            Text("Bienvenido ${email}", modifier = Modifier.weight(1f))
        }
    }
    Icon(imageVector = Icons.Filled.ExitToApp,
        contentDescription = "Exit",
        modifier = Modifier.clickable{onExitHome()}
    )
}

@Composable
fun Cuerpo(){
    Column {
        TextField(value ="",
            onValueChange = {},
            singleLine = true, label = { Text("Nombre Del Producto") },
            modifier = Modifier.padding(5.dp)
                .fillMaxWidth()
        )
        TextField(value ="",
            onValueChange = {},
            singleLine = true, label = { Text("Precio") },
            modifier = Modifier.padding(5.dp)
                .fillMaxWidth()
        )
        TextField(value ="",
            onValueChange = {},
            singleLine = true, label = { Text("Descripcion") },
            modifier = Modifier.padding(15.dp)
                .fillMaxWidth()
        )
        TextField(value ="",
            onValueChange = {},
            singleLine = true, label = { Text("URL de la imagen") },
            modifier = Modifier.padding(5.dp)
                .fillMaxWidth()
        )
        Button(onClick = {}) {
            Text("Agregar Producto")
        }
    }
}
@Composable
fun Listado(){
    LazyColumn {

    }
}

@Preview(showBackground = true)
@Composable
fun ver(){
    DominguezBorja_progamacion_firebaseTheme {
        RealHome {}
    }
}
