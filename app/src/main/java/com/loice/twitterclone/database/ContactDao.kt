package com.loice.twitterclone.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.loice.twitterclone.model.Contacts_Data

@Dao
 interface ContactDao {


    @Insert(onConflict= OnConflictStrategy.REPLACE)
    fun insertContact(contact: Contacts_Data)

    @Query("SELECT * FROM Contacts ORDER BY name")
    fun getAllContacts():LiveData<List<Contacts_Data>>

    @Query("SELECT * FROM Contacts WHERE contactId = :contactId")
    fun getContactById(contactId: Int): LiveData<Contacts_Data>

//a query method for deleting a contact with the annotation @Delete

    @Delete
    suspend fun deleteContactById(contact: Contacts_Data)

    @Update
    suspend fun updateContact(contact: Contacts_Data):Int



}

