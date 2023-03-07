package com.like_magic.gitapp.view

import com.like_magic.gitapp.domain.entity.UserEntity

interface UsersContract {

    interface View{
        fun showUsers(list: List<UserEntity>)
        fun navigateToUserPage(userEntity: UserEntity)
    }

    interface Presenter{
        fun attach(view:View)
        fun detach()

        fun loadData()
    }

}