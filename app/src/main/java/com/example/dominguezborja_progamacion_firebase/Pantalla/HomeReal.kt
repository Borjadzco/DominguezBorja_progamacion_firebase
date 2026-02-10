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
import androidx.compose.foundation.lazy.items
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
import com.example.dominguezborja_progamacion_firebase.Componentes.crud.Producto
import com.example.dominguezborja_progamacion_firebase.Componentes.crud.ViewModelCrud
import com.example.dominguezborja_progamacion_firebase.ui.theme.DominguezBorja_progamacion_firebaseTheme

@Composable
fun RealHome(viewModelCrud: ViewModelCrud = viewModel (),
             viewModelTienda: ViewModelTienda = viewModel(),
             onExitHome: () -> Unit,
             onViewProducto: (Producto) -> Unit){
    val productos by viewModelCrud.producto.collectAsState()
    val uiState by viewModelCrud.uistate.collectAsState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center) {

        Cabecera(uiState, onExitHome, viewModelTienda)
        Spacer(modifier = Modifier.padding(25.dp))
        Cuerpo(viewModelCrud, uiState)
        Listado(viewModelCrud, productos, onViewProducto)
    }
}
@Composable
fun Cabecera(uiState: UiStateTienda, onExitHome: () -> Unit, viewModelTienda: ViewModelTienda){
    Row(modifier = Modifier.fillMaxWidth()) {
        lateinit var email: String
        if (uiState.login.isNotEmpty()){
            var email = uiState.login
            Text("Bienvenido ${email}", modifier = Modifier.weight(1f))
        }else{
            var email = uiState.login
            Text("Bienvenido ${email}", modifier = Modifier.weight(1f))
        }
    }
    Icon(imageVector = Icons.Filled.ExitToApp,
        contentDescription = "Exit",
        modifier = Modifier
            .clickable{onExitHome()}
    )
}

@Composable
fun Cuerpo(viewModel: ViewModelCrud, uiState: UiStateTienda) {

    Column {
        TextField(
            value = uiState.nombre,
            onValueChange = { viewModel.onNombreChange(it) },
            label = { Text("Nombre del producto") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = uiState.precio,
            onValueChange = { viewModel.onPrecioChange(it) },
            label = { Text("Precio") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = uiState.descripcion,
            onValueChange = { viewModel.onDescripcionChange(it) },
            label = { Text("Descripción") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = uiState.imagenUrl,
            onValueChange = { viewModel.onImagenChange(it) },
            label = { Text("URL Imagen") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = { viewModel.addProducto()}) {
            Text("Agregar Producto")
        }
    }
}

@Composable
fun Listado(viewModel: ViewModelCrud,productos: List<Producto>, onViewProducto: (Producto) -> Unit) {
    LazyColumn {
        items(productos) { prod ->
            ProdItemCard(
                producto = prod,
                onDelete = { id -> viewModel.deleteProducto(id) },
                onView = {producto ->
                    onViewProducto(producto)
                }
            )
        }
    }
}
