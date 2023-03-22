package com.like_magic.gitapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_list")
data class UserDbModel(
    @PrimaryKey
    val login: String,
    val id: Int,
    val avatarUrl: String,
    val reposUrl:String
)