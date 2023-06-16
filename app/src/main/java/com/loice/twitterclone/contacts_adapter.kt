package com.loice.twitterclone
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.createBitmap
import androidx.recyclerview.widget.RecyclerView
import com.loice.twitterclone.databinding.ContactListBinding
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class TweetAdapter(var contact_list:List<Contacts_Data>):RecyclerView.Adapter<TweetViewHolder>() {
    lateinit var contactListBinding: ContactListBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetViewHolder {
        val binding=
            ContactListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TweetViewHolder(binding)

    }


    override fun onBindViewHolder(holder: TweetViewHolder, position: Int) {
        val currentcontact=contact_list[position]
        val binding=holder.binding
//     binding.ivAvatar.tag=currentTweet.avatar
        binding.tvContactName.text=currentcontact.contact_name
        binding.tvemail.text=currentcontact.contact_name
        binding.tvnumber.text=currentcontact.number
        Picasso
            .get()
            .load(currentcontact.avatar)
            .resize(80,80)
            .centerCrop()
            .transform(CropCircleTransformation())
            .into(binding.ivAvatar)
//            .placeholder(R.drawable.baseline_person_24)
//        error(R.drawable.baseline_person_24)





//

    }


    override fun getItemCount(): Int {
        return contact_list.size
    }

}

class TweetViewHolder(var binding: ContactListBinding):RecyclerView.ViewHolder(binding.root)
