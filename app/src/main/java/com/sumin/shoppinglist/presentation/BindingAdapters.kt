package com.sumin.shoppinglist.presentation

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout
import com.sumin.shoppinglist.R

@BindingAdapter("countErrorMessage")
fun bindCountErrorMessage(textInputLayout: TextInputLayout, isError: Boolean) {
    textInputLayout.error =
        if (isError) textInputLayout.context.getString(R.string.error_input_count) else null
}

@BindingAdapter("nameErrorMessage")
fun bindNameErrorMessage(textInputLayout: TextInputLayout, isError: Boolean){
    textInputLayout.error =
        if (isError) textInputLayout.context.getString(R.string.error_input_name) else null
}