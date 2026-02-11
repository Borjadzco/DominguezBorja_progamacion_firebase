package com.example.dominguezborja_progamacion_firebase.Componentes.crud

import androidx.lifecycle.ViewModel
import com.example.dominguezborja_progamacion_firebase.Componentes.UiState.UiStateTienda
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ViewModelCrud: ViewModel(){
    private val db = Firebase.firestore
    private val productosCollection = db.collection("productos")

    private val _producto = MutableStateFlow<List<Producto>>(emptyList())
    val producto: StateFlow<List<Producto>> = _producto

    private val _uiState = MutableStateFlow(UiStateTienda())
    val uistate: StateFlow<UiStateTienda> = _uiState.asStateFlow()

    fun onNombreChange(nombre: String){
        _uiState.value = _uiState.value.copy(nombre = nombre)
    }
    fun onPrecioChange(precio: String){
        _uiState.value = _uiState.value.copy(precio = precio)
    }

    fun onDescripcionChange(descripcion: String){
        _uiState.value = _uiState.value.copy(descripcion = descripcion)
    }

    fun onImagenChange(imagen: String){
        _uiState.value = _uiState.value.copy(imagenUrl = imagen)
    }

    fun addProducto() {
        val ui = _uiState.value

        val producto = Producto(
            nombre = ui.nombre,
            precio = ui.precio.toDoubleOrNull() ?: 0.0,
            descripcion = ui.descripcion,
            imagenUrl = ui.imagenUrl
        )

        productosCollection.add(producto)
    }
    init {
        getProductos()
    }

    fun getProductos() {
        productosCollection.addSnapshotListener { snapshot, _ ->
            if (snapshot != null) {
                val lista = snapshot.documents.mapNotNull {
                    it.toObject(Producto::class.java)?.copy(id = it.id)
                }
                _producto.value = lista
            }
        }
    }
    fun deleteProducto(id: String) {
        productosCollection.document(id).delete()
    }

    fun updateProducto(
        id: String,
        nombre: String,
        precio: String,
        descripcion: String,
        imagenUrl: String
    ) {
        val data = mapOf(
            "nombre" to nombre,
            "precio" to (precio.toDoubleOrNull() ?: 0.0),
            "descripcion" to descripcion,
            "imagenUrl" to imagenUrl
        )

        productosCollection.document(id).update(data)
    }

}