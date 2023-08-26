package com.loice.twitterclone.repository

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.LiveData
import com.loice.twitterclone.MyContactsApp
import com.loice.twitterclone.database.ContactsDB
import com.loice.twitterclone.model.Contacts_Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class ContactsRepository {
    private val database = ContactsDB.getDatabase(MyContactsApp.appContext)

    suspend fun saveContact(contact: Contacts_Data) {
        withContext(Dispatchers.IO) {
            database.getContactDao().insertContact(contact)

        }
    }

    fun getAllContacts(): LiveData<List<Contacts_Data>> {
        return database.getContactDao().getAllContacts()
    }

    fun getContactById(contactId: Int): LiveData<Contacts_Data> {
        return database.getContactDao().getContactById(contactId)
    }

    suspend fun deleteContact(contact: Contacts_Data) {
        return database.getContactDao().deleteContactById(contact)

    }



    suspend fun editContact(contactId: Int, name: String, phoneNumber: String, email: String) {
        withContext(Dispatchers.IO) {
            val existingContact = database.getContactDao().getContactById(contactId)
            existingContact.let {
                val updatedContact = it.copy(
                    name = name,
                    phoneNumber = phoneNumber,
                    email = email

                )
                database.getContactDao().updateContact(updatedContact)
            }
        }
    }

}

private fun <T> LiveData<T>.copy(name: String, phoneNumber: String, email: String): T {
    TODO("Not yet implemented")
}

