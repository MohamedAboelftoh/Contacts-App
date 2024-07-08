package com.contacts_application_task.domain.repo
import com.contacts_application_task.domain.models.Contact

interface ContactsRepo {
     fun getAllContactsFromLocal():MutableList<Contact>
     fun insertContactInLocal(contact: Contact)
     fun deleteContactFromLocal(contact: Contact)
}