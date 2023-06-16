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
        val contact8=Contacts_Data("https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8cHJvZmlsZSUyMGltYWdlfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60","maggy","maggy@gmail.com","+25416803467700")
        val contact9=Contacts_Data("https://images.unsplash.com/photo-1558203728-00f45181dd84?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cHJvZmlsZSUyMGltYWdlfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60","bosibori","bosibori@gmail.com","+2541234567899")
        val contact3=Contacts_Data("https://images.unsplash.com/photo-1502823403499-6ccfcf4fb453?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTd8fHByb2ZpbGUlMjBpbWFnZXxlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&w=500&q=60","joyce","joyce@gmail.com","+25410572569")
        val contact10=Contacts_Data("https://images.unsplash.com/photo-1506634572416-48cdfe530110?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MzQ5fHxwcm9maWxlJTIwaW1hZ2VzJTIwb2YlMjBjb2xvdXJlZCUyMHBlb3BsZXxlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&w=500&q=60","mathai","mathai@gmail.com","+25012457896")
        val contact11=Contacts_Data("https://images.unsplash.com/photo-1539614474468-f423a2d2270c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjY0fHxwcm9maWxlJTIwaW1hZ2VzJTIwb2YlMjBjb2xvdXJlZCUyMHBlb3BsZXxlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&w=500&q=60","nyaguthi","nyaguthi@gmail.com","+256784801234")
        val contact12=Contacts_Data("https://images.unsplash.com/photo-1632765854612-9b02b6ec2b15?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTk2fHxwcm9maWxlJTIwaW1hZ2VzJTIwb2YlMjBjb2xvdXJlZCUyMHBlb3BsZXxlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&w=500&q=60","jemimah","jemimah@gmail.com","+253769832356")
        val contact13=Contacts_Data("https://images.unsplash.com/photo-1529626455594-4ff0802cfb7e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NzN8fHByb2ZpbGUlMjBpbWFnZXMlMjBvZiUyMGNvbG91cmVkJTIwcGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60","omondi","omondi@gmail.com","+250245578443")
        val contact14=Contacts_Data("https://images.unsplash.com/photo-1487222477894-8943e31ef7b2?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NjJ8fHByb2ZpbGUlMjBpbWFnZXMlMjBvZiUyMGNvbG91cmVkJTIwcGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60","kirui","kirui@gmail.com","+254632167784")
        val contact15=Contacts_Data("https://images.unsplash.com/photo-1519699047748-de8e457a634e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjJ8fHByb2ZpbGUlMjBpbWFnZXMlMjBvZiUyMGNvbG91cmVkJTIwcGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60","ben","ben@gmail.com","+256382335643")



        var contactlist= mutableListOf(contact1,contact2,contact3,contact10,contact11,contact15,contact12,contact13,contact4,contact5,contact6,contact7,contact8,contact9,contact10)
        val tweetAdapter=TweetAdapter(contactlist)
        binding.rvContacts.layoutManager=LinearLayoutManager(this)
        binding.rvContacts.adapter=tweetAdapter

    }


}