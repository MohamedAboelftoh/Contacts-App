package com.contacts_application_task.presentation.common

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("app:error")
fun bindErrorInInputEditText(textInputLayout: TextInputLayout , error : String?){
    textInputLayout.error = error
}