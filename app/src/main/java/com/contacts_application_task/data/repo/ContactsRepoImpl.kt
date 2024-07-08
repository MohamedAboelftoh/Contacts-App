package com.contacts_application_task.data.repo

import com.contacts_application_task.data.local.ContactsDao
import com.contacts_application_task.domain.models.Contact
import com.contacts_application_task.domain.repo.ContactsRepo
import javax.inject.Inject

class ContactsRepoImpl (private val contactsDao: ContactsDao) : ContactsRepo {
    override fun getAllContactsFromLocal(): MutableList<Contact> {
        return contactsDao.getAllContact()
    }

    override fun insertContactInLocal(contact: Contact) {
        contactsDao.insertContact(contact)
    }

    override fun deleteContactFromLocal(contact: Contact) {
        contactsDao.deleteContact(contact)
    }
}