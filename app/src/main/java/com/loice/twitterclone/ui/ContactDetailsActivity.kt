package com.loice.twitterclone.ui

import android.content.Intent
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


  private lateinit var binding: ActivityContactDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ContactsViewModel()
        val contactId=intent.getIntExtra("CONTACT_ID",0)
        viewModel.getContactById(contactId).observe(this, Observer { contact ->
            binding.btDeleteContact.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    deleteContact(contact)
                }
            }
            if (contact != null) {
                displayContactDetails(contact)
                binding.ivEditContact.setOnClickListener {
                    val editIntent = Intent(this, EditContactActivity::class.java)
                    editIntent.putExtra("CONTACT_ID", contact.contactId)
                    startActivity(editIntent)
                }



            }


        })

    }

    private fun displayContactDetails(contact: Contacts_Data) {
        binding.tvName.text = contact.name.toString()
        binding.tvOtherContact.text = contact.phoneNumber.toString()
        binding.tvEmail.text=contact.email.toString()

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
 private suspend fun deleteContact(contact: Contacts_Data) {
        viewModel.deleteContact(contact)
        finish()
    }







}