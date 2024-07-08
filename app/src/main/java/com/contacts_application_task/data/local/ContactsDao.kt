package com.contacts_application_task.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.contacts_application_task.domain.models.Contact


@Dao
interface ContactsDao {
    @Query("select * from Contact")
    fun getAllContact():MutableList<Contact>
    @Insert
    fun insertContact(contact : Contact)
    @Delete
    fun deleteContact(contact: Contact)
}