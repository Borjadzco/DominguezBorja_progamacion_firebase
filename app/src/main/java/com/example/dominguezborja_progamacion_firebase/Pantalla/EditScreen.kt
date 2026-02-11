package com.example.dominguezborja_progamacion_firebase.Pantalla

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dominguezborja_progamacion_firebase.Componentes.crud.Producto
import com.example.dominguezborja_progamacion_firebase.Componentes.crud.ViewModelCrud

@Composable
fun EditarProducto(
    producto: Producto,
    viewModel: ViewModelCrud = viewModel(),
    onBack: () -> Unit
) {
    var nombre by remember { mutableStateOf(producto.nombre) }
    var precio by remember { mutableStateOf(producto.precio.toString()) }
    var descripcion by remember { mutableStateOf(producto.descripcion) }
    var imagenUrl by remember { mutableStateOf(producto.imagenUrl) }

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Editar producto", fontSize = 22.sp)

        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") }
        )

        TextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Precio") }
        )

        TextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            label = { Text("Descripción") }
        )

        TextField(
            value = imagenUrl,
            onValueChange = { imagenUrl = it },
            label = { Text("URL Imagen") }
        )

        Button(onClick = {
            viewModel.updateProducto(
                producto.id,
                nombre,
                precio,
                descripcion,
                imagenUrl
            )
            onBack()
        }) {
            Text("Guardar cambios")
        }
    }
}