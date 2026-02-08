package com.example.dominguezborja_progamacion_firebase

import android.os.Bundle
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
import com.example.dominguezborja_progamacion_firebase.Componentes.Navegacion.BasicNavigation
import com.example.dominguezborja_progamacion_firebase.Pantalla.Home
import com.example.dominguezborja_progamacion_firebase.ui.theme.DominguezBorja_progamacion_firebaseTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DominguezBorja_progamacion_firebaseTheme {
                BasicNavigation()
            }
        }
    }
}
