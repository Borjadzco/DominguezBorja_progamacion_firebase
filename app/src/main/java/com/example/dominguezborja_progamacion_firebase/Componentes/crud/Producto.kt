package com.example.dominguezborja_progamacion_firebase.Componentes.crud

data class Producto(
    val id: String = "",
    val nombre: String = "",
    val precio: Double = 0.0,
    val descripcion: String = "",
    val imagenUrl: String = ""
)