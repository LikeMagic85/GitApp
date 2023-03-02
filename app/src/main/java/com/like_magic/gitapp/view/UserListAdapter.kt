package com.like_magic.gitapp.view


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.like_magic.gitapp.databinding.ItemUserBinding
import com.like_magic.gitapp.domain.entity.UserEntity
import com.squareup.picasso.Picasso

class UserListAdapter:ListAdapter<UserEntity, UserViewHolder>(UserDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        with(holder){
            with(binding){
                userLoginValue.text = user.login
                Picasso.get().load(user.avatarUrl).into(userAvatar)
                userIdValue.text = user.id.toString()
            }
        }
    }
}
