package com.loice.twitterclone.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loice.twitterclone.model.Contacts_Data
import com.loice.twitterclone.repository.ContactsRepository
import kotlinx.coroutines.launch

class ContactsViewModel:ViewModel() {
    val contactsRepository=ContactsRepository()
    fun saveContact(contact:Contacts_Data){
        viewModelScope.launch {
            contactsRepository.saveContact(contact)
        }
    }

    fun getContacts():LiveData<List<Contacts_Data>>{
        return contactsRepository.getAllContacts()
    }
    fun getContactById(contactId: Int): LiveData<Contacts_Data> {
       return contactsRepository.getContactById(contactId)
    }
//  suspend fun deleteContact(contactId: Int) {
//        return contactsRepository.deleteContact(contactId)
//    }
 fun deleteContact(contactId: Int) {
    return contactsRepository.deleteContact(contactId)
//    viewModelScope.launch {
//        contactsRepository.deleteContact(contactId)
//    }
}

}



















