package com.loice.twitterclone.ui
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.loice.twitterclone.R
import com.loice.twitterclone.databinding.ContactListBinding
import com.loice.twitterclone.model.Contacts_Data
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ContactsAdapter(var contact_list:List<Contacts_Data>,val context:Context):RecyclerView.Adapter<ContactsViewHolder>() {
    lateinit var contactListBinding: ContactListBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        val binding=
            ContactListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ContactsViewHolder(binding)

    }


    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        val currentcontact=contact_list[position]
        val binding=holder.binding

        binding.tvContactName.text=currentcontact.name.toString()
        binding.tvemail.text=currentcontact.email
        binding.tvnumber.text=currentcontact.phoneNumber
        if (!currentcontact.imageUrl.isNullOrEmpty()) {
            Picasso
                .get()
                .load(currentcontact.imageUrl)
                .resize(80, 80)
                .centerCrop()
                .transform(CropCircleTransformation())
                .into(binding.ivAvatar)
        }

        binding.cvContact.setOnClickListener{
            val intent=Intent(context,ContactDetailsActivity::class.java)

            intent.putExtra("CONTACT_ID",currentcontact.contactId)

            context.startActivity(intent)
        }










    }


    override fun getItemCount(): Int {
        return contact_list.size
    }

}

class ContactsViewHolder(var binding: ContactListBinding):RecyclerView.ViewHolder(binding.root)
