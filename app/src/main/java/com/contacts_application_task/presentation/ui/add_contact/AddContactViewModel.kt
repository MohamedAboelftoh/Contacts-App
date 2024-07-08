package com.contacts_application_task.presentation.ui.add_contact

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.contacts_application_task.R
import com.contacts_application_task.domain.models.Contact
import com.contacts_application_task.domain.usecases.ContactsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddContactViewModel @Inject constructor(
    private val contactsUseCase: ContactsUseCase
) : ViewModel() {
    var name = MutableLiveData<String>()
    var description = MutableLiveData<String>()
    var phone = MutableLiveData<String>()
    var nameError = MutableLiveData<String?>()
    var descriptionError = MutableLiveData<String?>()
    var phoneError = MutableLiveData<String?>()
    var added = true
    fun addContact(){
        if(!validation()){
            added = false
            return}
        val contact = Contact(name= name.value , description = description.value , number = phone.value)
        contactsUseCase.insertContact(contact)
        added = true
    }
    private fun validation(): Boolean {
        var isValid : Boolean = true
        if( name.value.isNullOrBlank() ){
            nameError.postValue("Required")
            isValid = false
        }
        else{
            nameError.postValue(null)
        }
        if( phone.value.isNullOrBlank()){
           phoneError.postValue("Required")
            isValid = false
        }
        else{
            phoneError.postValue(null)
        }
        if( description.value.isNullOrBlank()){
            descriptionError.postValue("Required")
            isValid = false
        }
        else{
            descriptionError.postValue(null)
        }
        return isValid
    }
}