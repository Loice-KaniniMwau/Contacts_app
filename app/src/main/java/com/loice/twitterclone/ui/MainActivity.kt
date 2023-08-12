package com.loice.twitterclone.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.loice.twitterclone.ADDITIONAL_CONTACTS
import com.loice.twitterclone.databinding.ActivityMainBinding
import com.loice.twitterclone.model.Contacts_Data
import com.loice.twitterclone.viewmodel.ContactsViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val contactsViewModel: ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        contactsViewModel.getContacts()
            .observe(this, Observer { contactList ->
                displayContacts(contactList)
            })
        binding.btAdd.setOnClickListener {
            val intent = Intent(this, ADDITIONAL_CONTACTS::class.java)
            startActivity(intent)
        }
    }


    fun displayContacts(contactList: List<Contacts_Data>) {
        val tweetAdapter = TweetAdapter(contactList, this)
        binding.rvContacts.layoutManager = LinearLayoutManager(this)
        binding.rvContacts.adapter = tweetAdapter

    }


}