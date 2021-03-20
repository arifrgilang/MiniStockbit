package com.arifrgilang.ministockbit.util

import android.content.Context
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Button
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.arifrgilang.domain.base.state.*

fun <T> LifecycleOwner.observe(liveData: LiveData<T>, action: (t: T) -> Unit) {
    liveData.observe(this, Observer { it?.let { t -> action(t) } })
}

fun <T> LifecycleOwner.observe(liveData: MutableLiveData<T>, action: (t: T) -> Unit) {
    liveData.observe(this, Observer { it?.let { t -> action(t) } })
}

fun getProgressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }
}

fun getSmallProgressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 4f
        centerRadius = 24f
        start()
    }
}

fun validationHandler(
    state: FormState,
    onInvalid: () -> Unit,
    onValid: () -> Unit
){
    when(state){
        is Invalid -> { onInvalid() }
        is Valid -> { onValid() }
    }
}

fun loadHandler(
    state: UiState,
    onLoading: () -> Unit,
    onSuccess: () -> Unit,
    onError: (throwable: Throwable) -> Unit
){
    when(state){
        is Loading -> { onLoading() }
        is Success -> { onSuccess() }
        is Error -> {
            onError(state.error)
            Log.d("HTTP Exception", "${state.error.message}")
        }
    }
}

fun isEmailValid(email: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

/** makes visible a view. */
fun View.visible() {
    visibility = View.VISIBLE
}

/** makes gone a view. */
fun View.gone() {
    visibility = View.GONE
}

fun Button.enable() {
    isEnabled = true
}

fun Button.disable() {
    isEnabled = false
}

