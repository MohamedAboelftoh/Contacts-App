package com.contacts_application_task.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.contacts_application_task.domain.models.Contact
import com.contacts_application_task.domain.usecases.ContactsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val contactsUseCase : ContactsUseCase
):ViewModel() {
   fun getAllContacts():MutableList<Contact>{
       return contactsUseCase.getAllContacts()
   }
    fun deleteContact(contact: Contact){
        contactsUseCase.deleteContact(contact)
    }
}