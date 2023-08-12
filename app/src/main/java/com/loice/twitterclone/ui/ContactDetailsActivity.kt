package com.loice.twitterclone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.loice.twitterclone.R
import com.loice.twitterclone.databinding.ActivityAdditionalContactsBinding
import com.loice.twitterclone.databinding.ActivityContactDetailsBinding
import com.loice.twitterclone.model.Contacts_Data
import com.loice.twitterclone.viewmodel.ContactsViewModel
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ContactDetailsActivity : AppCompatActivity() {
    var contactId = 0
    private lateinit var viewModel: ContactsViewModel

    lateinit var binding: ActivityContactDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.btDeleteContact.setOnClickListener {
//            deleteContact()
//        }




        viewModel = ContactsViewModel()
        val contactId = intent.getIntExtra("CONTACT_ID", 0)

        viewModel.getContactById(contactId).observe(this, Observer { contact ->
            if (contact != null) {
                displayContactDetails(contact)
                binding.btDeleteContact.setOnClickListener {
                    deleteContacts()
                }
            } else {
                Toast.makeText(this, "Contact not found", Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun displayContactDetails(contact: Contacts_Data) {
        binding.tvName.text = contact.name
        binding.tvOtherContact.text = contact.phoneNumber
        binding.tvEmail.text=contact.email
//        binding.tvPhoneNumber.text = contact.phoneNumber
        if (!contact.imageUrl.isNullOrEmpty()) {
            Picasso
                .get()
                .load(contact.imageUrl)
                .resize(80, 80)
                .centerCrop()
                .transform(CropCircleTransformation())
                .into(binding.imageView)
        }
    }

     private fun deleteContacts() {
        viewModel.deleteContact(contactId)
         Toast.makeText(this,"contact deleteed",Toast.LENGTH_SHORT).show()
        finish()
    }




}