package com.loice.twitterclone

import android.content.Intent
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
     binding.btAdd.setOnClickListener {
         val intent = Intent(this,ADDITIONAL_CONTACTS::class.java)
         startActivity(intent)
     }
    }


    fun displayContacts(){

        val contact1=Contacts_Data("https://media.istockphoto.com/id/1407759041/photo/confident-happy-beautiful-hispanic-student-girl-indoor-head-shot-portrait.jpg?s=612x612&w=0&k=20&c=12CUDMMzA78XFt16_0PynybQ5O4EBpNSIWSlYsCA8Zc=","mary","mwauloicegmail.com","+254707562960")
        val contact2=Contacts_Data("https://media.istockphoto.com/id/953079238/photo/smiling-man-with-hat-and-sunglasses.jpg?s=612x612&w=0&k=20&c=92ZabzQl2W9eu_8hwdkXuW_6DZ0qxiWYYOAaC2NE1do=","jecinta","jecinta@gmail.com","+25638239282")
        val contact4=Contacts_Data("https://media.istockphoto.com/id/1437816897/photo/business-woman-manager-or-human-resources-portrait-for-career-success-company-we-are-hiring.jpg?s=612x612&w=0&k=20&c=tyLvtzutRh22j9GqSGI33Z4HpIwv9vL_MZw_xOE19NQ=","faith","faith@gmail.com","+25638239282")

        val contact5=Contacts_Data("https://media.istockphoto.com/id/1386479313/photo/happy-millennial-afro-american-business-woman-posing-isolated-on-white.jpg?s=612x612&w=0&k=20&c=8ssXDNTp1XAPan8Bg6mJRwG7EXHshFO5o0v9SIj96nY=","kanini","kanini@gmail.com","+254707562960")
        val contact6=Contacts_Data("https://media.istockphoto.com/id/1381221247/photo/beautiful-afro-girl-with-curly-hairstyle.jpg?s=612x612&w=0&k=20&c=oIKW-mPhNnz1o5ltYCtakMZthk8gaLbugmcl7KeH4IY=","joanne","joanne@gmail.com","+25638239282")
        val contact7=Contacts_Data("https://media.istockphoto.com/id/1411155612/photo/side-profile-of-a-beautiful-young-black-woman-thinking-and-looking-powerful-standing-against.jpg?s=612x612&w=0&k=20&c=q64YMacmkFA78WDmlShv9Q44va-8k2iDaYFIkWNeyqg=","ndemo","ndemo@gmail.com","+25638239282")
        val contact8=Contacts_Data("https://media.istockphoto.com/id/1411155612/photo/side-profile-of-a-beautiful-young-black-woman-thinking-and-looking-powerful-standing-against.jpg?s=612x612&w=0&k=20&c=q64YMacmkFA78WDmlShv9Q44va-8k2iDaYFIkWNeyqg=","maggy","maggy@gmail.com","+25638239282")
        val contact9=Contacts_Data("https://media.istockphoto.com/id/1411155612/photo/side-profile-of-a-beautiful-young-black-woman-thinking-and-looking-powerful-standing-against.jpg?s=612x612&w=0&k=20&c=q64YMacmkFA78WDmlShv9Q44va-8k2iDaYFIkWNeyqg=","bosibori","bosibori@gmail.com","+25638239282")
        val contact10=Contacts_Data("https://media.istockphoto.com/id/1411155612/photo/side-profile-of-a-beautiful-young-black-woman-thinking-and-looking-powerful-standing-against.jpg?s=612x612&w=0&k=20&c=q64YMacmkFA78WDmlShv9Q44va-8k2iDaYFIkWNeyqg=","joyce","joyce@gmail.com","+25638239282")


        var contactlist= mutableListOf(contact1,contact2,contact4,contact5,contact6,contact7,contact8,contact9,contact10)
        val tweetAdapter=TweetAdapter(contactlist)
        binding.rvContacts.layoutManager=LinearLayoutManager(this)
        binding.rvContacts.adapter=tweetAdapter

    }


}