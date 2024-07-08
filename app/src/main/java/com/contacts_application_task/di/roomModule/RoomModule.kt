package com.contacts_application_task.di.roomModule

import android.content.Context
import androidx.room.Room
import com.contacts_application_task.data.local.ContactDataBase
import com.contacts_application_task.data.local.ContactsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideContactsDataBase(@ApplicationContext context: Context): ContactDataBase {
        return Room.databaseBuilder(context, ContactDataBase::class.java,"contact Data Base")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    @Singleton
    fun provideContactsDao(contactDataBase: ContactDataBase): ContactsDao {
        return contactDataBase.ContactsDao()
    }
}