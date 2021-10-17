package com.example.githubuserapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubuserapp.databinding.ItemRowUserBinding

class ListUserAdapter(private val listUser: ArrayList<User>) :
    RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val ( username,
         name,
         avatar,
         company,
         location,
         repository ,
         follower,
         following) = listUser[position]
        holder.binding.tvUsername.text = username
        holder.binding.tvFollowers.text = follower
        holder.binding.tvFollowing.text = following.toString()

        Glide.with(holder.itemView.context)
            .load(avatar)
            .into(holder.binding.ivAvatar)
    }

    override fun getItemCount(): Int =listUser.size

    class ListViewHolder(var binding: ItemRowUserBinding) : RecyclerView.ViewHolder(binding.root)
}