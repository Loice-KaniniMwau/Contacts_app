package com.loice.twitterclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.loice.twitterclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        displayContacts()
    }


    fun displayContacts(){
        val contact1=Contacts_Data("Silvia","mary","+254","+254707562960",true,"personal","+254354223")
        val contact2=Contacts_Data("Mary","jecinta","+256","+25638239282",false,"business","+25675322")
        var contactlist= mutableListOf(contact1,contact2)
        val tweetAdapter=TweetAdapter(contactlist)
        binding.rvContacts.layoutManager=LinearLayoutManager(this)
        binding.rvContacts.adapter=tweetAdapter

    }
}