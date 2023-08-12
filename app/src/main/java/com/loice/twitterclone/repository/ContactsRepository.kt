package com.loice.twitterclone.repository

import androidx.lifecycle.LiveData
import com.loice.twitterclone.MyContactsApp
import com.loice.twitterclone.database.ContactsDB
import com.loice.twitterclone.model.Contacts_Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsRepository {
    val database=ContactsDB.getDatabase(MyContactsApp.appContext)
   suspend fun saveContact(contact:Contacts_Data){
        withContext(Dispatchers.IO){
            database.getContactDao().insertContact(contact)

        }
    }

    fun getAllContacts():LiveData<List<Contacts_Data>>{
        return  database.getContactDao().getAllContacts()
    }
    fun getContactById(contactId: Int): LiveData<Contacts_Data> {
        return database.getContactDao().getContactById(contactId)
    }
   fun deleteContact(contactId: Int) {
        return database.getContactDao().deleteContact(contactId)
//       withContext(Dispatchers.IO){
//           database.getContactDao().deleteContact(contactId)
//       }
    }
}