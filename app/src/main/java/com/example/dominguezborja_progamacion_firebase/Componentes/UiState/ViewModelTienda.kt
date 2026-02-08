package com.example.dominguezborja_progamacion_firebase.Componentes.UiState

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ViewModelTienda : ViewModel() {

    private val auth = FirebaseAuth.getInstance()

    private val _uiState = MutableStateFlow(UiStateTienda())
    val uistate: StateFlow<UiStateTienda> = _uiState.asStateFlow()

    fun onEmailChange(email: String) {
        _uiState.value = _uiState.value.copy(login = email)
    }

    fun onPasswordChange(password: String) {
        _uiState.value = _uiState.value.copy(contraseña = password)
    }

    fun onEmailRegistroChange(email: String){
        _uiState.value = _uiState.value.copy(loginRegistro = email)
    }
    fun onContraseñaRegistroChange(contraseña: String){
        _uiState.value = _uiState.value.copy(contraseñaRegistro = contraseña)
    }
    fun onContraseñaRegistroNuevaChange(contraseña: String){
        _uiState.value = _uiState.value.copy(contraseñaRegistroNueva = contraseña)
    }

    fun login(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        val email = _uiState.value.login
        val password = _uiState.value.contraseña

        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener {
                onError(it.message ?: "Error al iniciar sesión")
            }
    }

    fun register(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        val email = _uiState.value.loginRegistro
        val password = _uiState.value.contraseñaRegistro
        val password2 = _uiState.value.contraseñaRegistroNueva
        if (password == password2){
            auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener { onSuccess() }
                .addOnFailureListener {
                    onError(it.message ?: "Error al registrar")
                }
        }
    }
}