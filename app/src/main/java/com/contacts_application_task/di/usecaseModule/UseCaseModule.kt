package com.contacts_application_task.di.usecaseModule

import com.contacts_application_task.domain.repo.ContactsRepo
import com.contacts_application_task.domain.usecases.ContactsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideContactsUseCase(contactsRepo: ContactsRepo): ContactsUseCase {
        return ContactsUseCase(contactsRepo)
    }
}