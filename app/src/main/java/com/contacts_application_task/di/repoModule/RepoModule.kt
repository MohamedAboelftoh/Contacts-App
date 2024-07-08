package com.contacts_application_task.di.repoModule

import com.contacts_application_task.data.local.ContactsDao
import com.contacts_application_task.data.repo.ContactsRepoImpl
import com.contacts_application_task.domain.repo.ContactsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepoModule {
    @Provides
    fun provideContactsRepo(contactsDao: ContactsDao): ContactsRepo {
        return ContactsRepoImpl(contactsDao)
    }
}