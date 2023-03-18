package com.like_magic.gitapp.view

import com.like_magic.gitapp.domain.entity.UserEntity
import com.like_magic.gitapp.domain.entity.UserRepoEntity

interface UsersContract {

    interface MainView{
        fun showUsers(list: List<UserEntity>)
        fun navigateToUserPage(userEntity: UserEntity)
        fun showError(message:String)
    }

    interface Presenter{
        fun attach(mainView:MainView)
        fun attach(view:UserFragmentView)
        fun attach(view:UsersRepoFragmentView)
        fun detach()
        fun loadData()
        fun getUser(login: String)
        fun getUsersRepoList(url:String)
        fun getUsersRepo(url:String)
    }

    interface UserFragmentView{
        fun showUsersReposList(list:List<UserRepoEntity>)
        fun showSnackBar()

    }

    interface UsersRepoFragmentView {
        fun showRepo(userRepoEntity: UserRepoEntity)
    }

}