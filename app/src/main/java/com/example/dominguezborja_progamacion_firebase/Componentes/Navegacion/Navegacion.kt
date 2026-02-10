package com.example.dominguezborja_progamacion_firebase.Componentes.Navegacion

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.dominguezborja_progamacion_firebase.Pantalla.DetalleProducto
import com.example.dominguezborja_progamacion_firebase.Pantalla.Home
import com.example.dominguezborja_progamacion_firebase.Pantalla.RealHome
import com.example.dominguezborja_progamacion_firebase.Pantalla.Registro

@Composable
fun BasicNavigation(){
    val backStack = remember { mutableStateListOf<Any>(Routes.Login) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = {
            key ->
            when(key){
                is Routes.Login -> NavEntry(key){
                    Home(
                        navigationToDetail = {
                        backStack.add(Routes.Registrar)
                    },
                        onLoginSuccess = {
                            backStack.add(Routes.Home)
                        }
                    )
                }
                is Routes.Registrar -> NavEntry(key){
                    Registro(
                        navegationCancel = {
                            backStack.removeLastOrNull()
                        },
                        onRegisterSuccess = {
                            backStack.add(Routes.Home)
                        }
                    )
                }
                is Routes.Home -> NavEntry(key){
                    RealHome(
                        onExitHome = {
                            backStack.removeLastOrNull()
                        },
                        onViewProducto = {
                            producto ->
                            backStack.add(Routes.Detalle(producto))
                        }
                    )
                }
                is Routes.Detalle -> NavEntry(key) {
                    DetalleProducto(
                        producto = key.producto,
                        onBack = { backStack.removeLastOrNull() }
                    )
                }
                else -> NavEntry(key = Unit) {
                    Text("error Navegacion")
                }
            }
        }
    )
}