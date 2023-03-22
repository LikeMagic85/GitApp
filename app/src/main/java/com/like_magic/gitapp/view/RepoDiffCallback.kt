package com.like_magic.gitapp.view

import androidx.recyclerview.widget.DiffUtil
import com.like_magic.gitapp.domain.entity.UserRepoEntity

class RepoDiffCallback:DiffUtil.ItemCallback<UserRepoEntity>() {
    override fun areItemsTheSame(oldItem: UserRepoEntity, newItem: UserRepoEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserRepoEntity, newItem: UserRepoEntity): Boolean {
        return oldItem == newItem
    }
}