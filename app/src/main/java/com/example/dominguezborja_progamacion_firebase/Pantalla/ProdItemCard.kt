package com.example.dominguezborja_progamacion_firebase.Pantalla


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.dominguezborja_progamacion_firebase.Componentes.crud.Producto

@Composable
fun ProdItemCard(
    producto: Producto,
    onDelete: (String) -> Unit,
    onEdit: (Producto) -> Unit = {},
    onView: (Producto) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(Color(0xFFD0D0D0)),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = producto.nombre)
            Text(text = "${producto.precio}")
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Ver",
                modifier = Modifier.clickable { onView(producto) }
            )

            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Editar",
                modifier = Modifier.clickable { onEdit(producto) }
            )

            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Eliminar",
                modifier = Modifier.clickable { onDelete(producto.id) }
            )
        }
    }
}
