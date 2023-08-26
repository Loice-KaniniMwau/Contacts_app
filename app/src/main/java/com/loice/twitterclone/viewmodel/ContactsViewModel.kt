package com.loice.twitterclone.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loice.twitterclone.model.Contacts_Data
import com.loice.twitterclone.repository.ContactsRepository
import kotlinx.coroutines.launch

class ContactsViewModel:ViewModel() {
   private val contactsRepository=ContactsRepository()
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

 suspend fun deleteContact(contact: Contacts_Data) {
    return contactsRepository.deleteContact(contact)
}
suspend fun updateContact(contactId: Int,name: String, phoneNumber: String, email: String){
    return contactsRepository.editContact(contactId,name,phoneNumber,email)
}


}



















