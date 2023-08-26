package com.loice.twitterclone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.loice.twitterclone.database.ContactsDB
import com.loice.twitterclone.databinding.ActivityEditContactBinding
import com.loice.twitterclone.model.Contacts_Data
import com.loice.twitterclone.viewmodel.ContactsViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EditContactActivity : AppCompatActivity() {
   private lateinit var viewModel: ContactsViewModel
   private lateinit var contactsData: Contacts_Data
    private lateinit var binding: ActivityEditContactBinding
    private lateinit var database:ContactsDB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityEditContactBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ContactsViewModel()

        val contactId = intent.getIntExtra("CONTACT_ID", contactsData.contactId)

        viewModel.getContactById(contactId).observe(this, Observer { contact ->

            if (contact != null) {
                populateUI(contact)
                binding.btnSave.setOnClickListener {
                    CoroutineScope(Dispatchers.IO).launch {
                        updateContact(contactId)
                        finish()
                    }

                }
            } else {
                Toast.makeText(this, "Contact not found", Toast.LENGTH_SHORT).show()
                finish()
            }


        })



    }




private fun populateUI(contact: Contacts_Data) {
    binding.etUserName.setText(contact.name)
    binding.etPhoneNumber.setText(contact.phoneNumber)
    binding.etEmail.setText(contact.email)


}

 suspend fun updateContact(contactId:Int) {
    val updatedName = binding.etUserName.text.toString()
    val updatedPhoneNumber = binding.etPhoneNumber.text.toString()
    val updatedEmail = binding.etEmail.text.toString()

     viewModel.updateContact(
         contactId = contactId,
         name = updatedName,
         phoneNumber = updatedPhoneNumber,
         email = updatedEmail
     )
}
}