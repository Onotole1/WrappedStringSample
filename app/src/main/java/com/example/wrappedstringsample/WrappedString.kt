package com.example.wrappedstringsample

import android.content.Context
import android.widget.TextView
import androidx.annotation.StringRes

sealed class WrappedString {
    data class Resource(
        @StringRes val resource: Int,
        val args: List<Any> = emptyList()
    ) : WrappedString()

    data class Wrapped(val value: String) : WrappedString()
    object Empty : WrappedString()
}

fun TextView.setText(wrappedString: WrappedString) {
    text = wrappedString.toString(context)
}

fun WrappedString.toString(context: Context): String =
    when (this) {
        is WrappedString.Resource -> context.getString(resource, args)
        is WrappedString.Wrapped -> value
        WrappedString.Empty -> ""
    }