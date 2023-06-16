package com.loice.twitterclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import com.loice.twitterclone.databinding.ActivityAdditionalContactsBinding

class ADDITIONAL_CONTACTS : AppCompatActivity() {
    lateinit var binding: ActivityAdditionalContactsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAdditionalContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btAddContact.setOnClickListener {
           val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        errors()
        validateContacts()

    }

    private fun errors(){
        var name=binding.etName.text.toString()
        var email =binding.etEmail.text.toString()
        var phoneNumber=binding.etNumber.text.toString()
        var error=false
        if(name.isBlank()){
            binding.tilName.error="enter first name"
            error=true
        }
        else{
            binding.tilName.error=null
        }
        if(email.isBlank()){
            binding.tilEmail.error="enter email"
            error=true
        }
        else{
            binding.tilEmail.error=null
        }
        if(phoneNumber.isBlank()){
            binding.tilNumber.error="enter password"
            error=true
        }
        else{
            binding.tilNumber.error=null
        }


    }
    fun validateContacts(){
        binding.tilName.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilName.error = null
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
        binding.tilEmail.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilEmail.error = null
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
        binding.tilNumber.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilNumber.error = null
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })


    }


}