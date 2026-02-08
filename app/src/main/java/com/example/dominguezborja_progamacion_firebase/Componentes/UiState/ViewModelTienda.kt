package com.example.dominguezborja_progamacion_firebase.Componentes.UiState

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ViewModelTienda: ViewModel() {
    private val _uiState = MutableStateFlow(UiStateTienda())
    val uistate: StateFlow<UiStateTienda> = _uiState.asStateFlow()

}