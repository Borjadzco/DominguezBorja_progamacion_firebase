package com.example.dominguezborja_progamacion_firebase.Componentes.Navegacion

import com.example.dominguezborja_progamacion_firebase.Componentes.crud.Producto

sealed class Routes {
    data object Login
    data object Registrar
    data object  Home

    data class Detalle(val producto: Producto)

    data class EditarProducto(val producto: Producto)
}