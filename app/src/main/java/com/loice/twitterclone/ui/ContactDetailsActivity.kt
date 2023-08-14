package com.loice.twitterclone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.loice.twitterclone.R
import com.loice.twitterclone.databinding.ActivityAdditionalContactsBinding
import com.loice.twitterclone.databinding.ActivityContactDetailsBinding
import com.loice.twitterclone.model.Contacts_Data
import com.loice.twitterclone.repository.ContactsRepository
import com.loice.twitterclone.viewmodel.ContactsViewModel
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ContactDetailsActivity : AppCompatActivity() {
    var contactId = 0
    private lateinit var viewModel: ContactsViewModel
    val contactsRepository= ContactsRepository()

    lateinit var binding: ActivityContactDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)





        viewModel = ContactsViewModel()
        val contactId = intent.getIntExtra("CONTACT_ID", 0)
        viewModel.getContactById(contactId).observe(this, Observer { contact ->
            binding.btDeleteContact.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    deleteContact(contact)
                }

            }

            if (contact != null) {
                displayContactDetails(contact)

            } else {
                Toast.makeText(this, "Contact not found", Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun displayContactDetails(contact: Contacts_Data) {
        binding.tvName.text = contact.name
        binding.tvOtherContact.text = contact.phoneNumber
        binding.tvEmail.text=contact.email

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
  suspend fun deleteContact(contact: Contacts_Data) {
        viewModel.deleteContact(contact)
        Toast.makeText(this, "Contact deleted", Toast.LENGTH_SHORT).show()
        finish()
    }





}