package com.like_magic.gitapp.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserRepoEntity(val id: Int, val name: String, val forks: Int, val url: String):Parcelable