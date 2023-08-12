package com.loice.twitterclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.viewModels
import com.loice.twitterclone.databinding.ActivityAdditionalContactsBinding
import com.loice.twitterclone.model.Contacts_Data
import com.loice.twitterclone.ui.MainActivity
import com.loice.twitterclone.viewmodel.ContactsViewModel

class ADDITIONAL_CONTACTS : AppCompatActivity() {
    lateinit var binding: ActivityAdditionalContactsBinding
    val contactsViewModel: ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdditionalContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btAddContact.setOnClickListener {

            validateContact()
        }


    }

    fun validateContact() {
        val name = binding.etName.text.toString()
        val email = binding.etEmail.text.toString()
        val phoneNumber = binding.etNumber.text.toString()
        var error = false
        if (name.isBlank()) {
            binding.tilName.error = getString(R.string.enter_first_name)
            error = true
        }

        if (email.isBlank()) {
            binding.tilEmail.error = getString(R.string.enter_email)
            error = true
        }

        if (phoneNumber.isBlank()) {
            binding.tilNumber.error = getString(R.string.enter_phone_number)
            error = true
        }
        if (!error) {
            val newContact = Contacts_Data(0, name, phoneNumber, email, imageUrl = "")
            contactsViewModel.saveContact(newContact)
//            saveContact()
            Toast.makeText(this, "contact saved", Toast.LENGTH_LONG)
                .show()
            finish()
        }


    }

//    fun saveContact() {
//        val imageUrl=binding.ivImage
//        val name = binding.etName.text.toString()
//        val phone = binding.etName.text.toString()
//        val email = binding.etName.text.toString()
//        val contact = Contacts_Data(
//            0,
//            name,
//            phone,
//            email,
//            "https://media.istockphoto.com/id/1386479313/photo/happy-millennial-afro-american-business-woman-posing-isolated-on-white.jpg?s=612x612&w=0&k=20&c=8ssXDNTp1XAPan8Bg6mJRwG7EXHshFO5o0v9SIj96nY="
//        )
//        contactsViewModel.saveContact(contact)
//    }


}