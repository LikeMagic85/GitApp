package com.like_magic.gitapp.data.database

import androidx.room.*

@Dao
interface UsersDao {
    @Query("SELECT * FROM users_list")
    fun getAllUser(): List<UserDbModel>

    @Query("SELECT * FROM users_list WHERE login == :login")
    fun getUser(login:String): UserDbModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertListOfUsers(userList: List<UserDbModel>)

}
