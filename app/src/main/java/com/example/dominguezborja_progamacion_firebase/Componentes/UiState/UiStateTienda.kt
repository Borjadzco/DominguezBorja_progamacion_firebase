package com.example.dominguezborja_progamacion_firebase.Componentes.UiState

data class UiStateTienda (
    val login: String = "",
    val contraseña: String = "",
    val loginRegistro: String = "",
    val contraseñaRegistro: String = "",
    val contraseñaRegistroNueva: String = "",
    val igual: Boolean = false,

    val nombre: String = "",
    val precio: String = "",
    val descripcion: String = "",
    val imagenUrl: String = ""
)