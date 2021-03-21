package com.arifrgilang.ministockbit.util

import android.content.Context
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.arifrgilang.domain.base.state.*
import com.arifrgilang.ministockbit.R
import java.text.DecimalFormat

fun <T> LifecycleOwner.observe(liveData: LiveData<T>, action: (t: T) -> Unit) {
    liveData.observe(this, Observer { it?.let { t -> action(t) } })
}

fun getProgressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }
}

fun formatPriceChanges(value: Double): String {
    return DecimalFormat("##.#####").format(value)
}

fun formatPriceChangesPercentage(value: Double): String {
    return DecimalFormat("##.##").format(value)
}

fun formatPrice(value: Double): String {
    return DecimalFormat("##,##").format(value)
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

fun TextView.changeTextColor(changesPrice: Double, context: Context) {
    if (changesPrice < 0) {
        this.setTextColor(ContextCompat.getColor(context, R.color.red))
    } else if (changesPrice > 0) {
        this.setTextColor(ContextCompat.getColor(context, R.color.green))
    }
}

fun String.addPrefix(): String {
    val value = this.toDouble()
    return when {
        value > 0 -> {
            "+$value"
        }
        else -> this
    }
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

