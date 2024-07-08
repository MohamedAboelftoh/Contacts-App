package com.contacts_application_task.domain.usecases

import com.contacts_application_task.domain.models.Contact
import com.contacts_application_task.domain.repo.ContactsRepo
import javax.inject.Inject

class ContactsUseCase (private val contactsRepo: ContactsRepo) {
     fun getAllContacts() = contactsRepo.getAllContactsFromLocal()
     fun insertContact(contact: Contact){
        contactsRepo.insertContactInLocal(contact)
    }
     fun deleteContact(contact: Contact){
        contactsRepo.deleteContactFromLocal(contact)
    }
}