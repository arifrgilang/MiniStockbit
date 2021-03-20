package com.arifrgilang.ministockbit.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arifrgilang.domain.base.state.Error
import com.arifrgilang.domain.base.state.FormState
import com.arifrgilang.domain.base.state.Loading
import com.arifrgilang.domain.base.state.Success
import com.arifrgilang.domain.base.state.UiState
import com.arifrgilang.ministockbit.util.Constant.USER_TOKEN
import com.arifrgilang.ministockbit.util.isEmailValid
import com.orhanobut.hawk.Hawk

class LoginViewModel : ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    private val _formState = MutableLiveData<FormState>()

    val uiState: LiveData<UiState> get() = _uiState
    val formState: LiveData<FormState> get() = _formState

    fun login(email: String, password: String) {
        _uiState.value = Loading
        if(email.isNotEmpty() && password.isNotEmpty()){
            if(isEmailValid(email)){
                Hawk.put(USER_TOKEN, email+password)
                _uiState.value = Success
            } else {
                _uiState.value = Error(Throwable("Invalid E-mail"))
            }
        } else {
            _uiState.value = Error(Throwable("E-mail and Password is required"))
        }
    }
}