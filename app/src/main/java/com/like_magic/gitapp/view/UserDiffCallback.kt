package com.like_magic.gitapp.view

import androidx.recyclerview.widget.DiffUtil
import com.like_magic.gitapp.domain.entity.UserEntity

class UserDiffCallback:DiffUtil.ItemCallback<UserEntity>() {
    override fun areItemsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
        return oldItem == newItem
    }
}