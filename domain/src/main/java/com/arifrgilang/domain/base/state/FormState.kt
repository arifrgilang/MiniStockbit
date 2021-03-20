package com.arifrgilang.domain.base.state

sealed class FormState

object Valid : FormState()
object Invalid : FormState()
//class Error(val error: Throwable) : UiState()