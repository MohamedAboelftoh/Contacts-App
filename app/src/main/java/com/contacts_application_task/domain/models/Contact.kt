package com.contacts_application_task.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true)
    var id : Int ?= null ,
    @ColumnInfo
    var name : String ?= null,
    @ColumnInfo
    var description : String?= null,
    @ColumnInfo
    var number: String ?= null
    ): Serializable
