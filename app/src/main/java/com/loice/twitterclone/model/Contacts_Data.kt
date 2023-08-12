package com.loice.twitterclone.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "Contacts")
data class Contacts_Data(
    @PrimaryKey(autoGenerate = true) @NonNull var contactId: Int,
    var name: String,
    var phoneNumber: String,
//    var location:String,
    var email: String,
    var imageUrl: String?,
//    var otherNumber:String,

)
//a data class to define what our details will be ..eg name ,number etc
//the table name
