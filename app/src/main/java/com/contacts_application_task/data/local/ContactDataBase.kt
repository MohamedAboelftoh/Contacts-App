package com.contacts_application_task.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.contacts_application_task.domain.models.Contact

@Database(entities = [Contact:: class], version = 1 , exportSchema = true)
abstract class ContactDataBase : RoomDatabase() {
    abstract fun ContactsDao(): ContactsDao
}