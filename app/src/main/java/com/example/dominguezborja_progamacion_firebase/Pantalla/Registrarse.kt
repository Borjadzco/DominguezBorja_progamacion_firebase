package com.example.dominguezborja_progamacion_firebase.Pantalla

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dominguezborja_progamacion_firebase.Componentes.UiState.UiStateTienda
import com.example.dominguezborja_progamacion_firebase.Componentes.UiState.ViewModelTienda
import com.example.dominguezborja_progamacion_firebase.ui.theme.DominguezBorja_progamacion_firebaseTheme
import com.google.firebase.auth.FirebaseAuth
@Composable
fun Registro(navegationCancel:()-> Unit,
             viewModelTienda: ViewModelTienda = viewModel(),
             onRegisterSuccess: () -> Unit){
    val uiState by viewModelTienda.uistate.collectAsState()

 Column (
     horizontalAlignment = Alignment.CenterHorizontally,
     modifier = Modifier.fillMaxSize(),
     verticalArrangement = Arrangement.Center) {
     Text("Registro de Usuario/a",
         fontSize = 30.sp,
         fontWeight = FontWeight.Bold)
     Spacer(Modifier.padding(10.dp))
     IntroducirRegi(navegationCancel, viewModelTienda, uiState, onRegisterSuccess)
 }
}

@Composable
fun IntroducirRegi(navegationCancel:()-> Unit, viewmodel: ViewModelTienda, uiState: UiStateTienda, onRegisterSuccess: () -> Unit){
    Column(modifier = Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(value = uiState.loginRegistro,
            onValueChange = {viewmodel.onEmailRegistroChange(it)},
            singleLine = true, label = { Text("Email") },
            modifier = Modifier.padding(10.dp)
                .fillMaxWidth()
        )
        TextField(value = uiState.contraseñaRegistro,
            onValueChange = {viewmodel.onContraseñaRegistroChange(it)},
            singleLine = true, label = { Text("Contraseña") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.padding(10.dp)
                .fillMaxWidth()
        )
        TextField(value = uiState.contraseñaRegistroNueva,
            onValueChange = {viewmodel.onContraseñaRegistroNuevaChange(it)},
            singleLine = true, label = { Text("Repetir Contraseña") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.padding(10.dp)
                .fillMaxWidth()
        )

        Button(onClick = {viewmodel.register(
            onSuccess = onRegisterSuccess,
            onError = {println(it)}
        )}, modifier = Modifier.fillMaxWidth()
            .padding(10.dp)) {
            Text("Entrar")
        }
        Button(onClick = {
            navegationCancel()
        }, modifier = Modifier.fillMaxWidth()
            .padding(10.dp)) {
            Text("Cancelar")
        }
    }
}

