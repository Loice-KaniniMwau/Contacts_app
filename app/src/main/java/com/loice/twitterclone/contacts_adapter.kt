package com.loice.twitterclone
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.loice.twitterclone.databinding.ContactListBinding

class TweetAdapter(var contact_list:List<Contacts_Data>):RecyclerView.Adapter<TweetViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetViewHolder {
        val binding=
            ContactListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TweetViewHolder(binding)

    }

    override fun onBindViewHolder(holder: TweetViewHolder, position: Int) {
        val currentTweet=contact_list.get(position)
        val binding=holder.binding
        binding.tvContactName.text=currentTweet.contact_name
        binding.tvCountryCode.text = currentTweet.country_code
        binding.tvPhoneNumber.text=currentTweet.phone_number
        binding.tvFavourite.text=currentTweet.favourite.toString()
        binding.tvContactType.text=currentTweet.contact_type
        binding.tvOtherNumber.text=currentTweet.other_number

    }

    override fun getItemCount(): Int {
        return contact_list.size
    }
}

class TweetViewHolder(var binding: ContactListBinding):RecyclerView.ViewHolder(binding.root)
