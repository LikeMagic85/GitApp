package com.like_magic.gitapp.data

import com.like_magic.gitapp.domain.UserRepository
import com.like_magic.gitapp.data.network.ApiFactory
import com.like_magic.gitapp.domain.dto.UserEntityDto
import com.like_magic.gitapp.domain.entity.UserEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserRepositoryImpl : UserRepository {

    private val mapper = Mapper()

    override fun loadData(callback:(List<UserEntity>) -> Unit) {
        val tempList = mutableListOf<UserEntity>()
        ApiFactory.apiService.getUserList().enqueue(object : Callback<List<UserEntityDto>> {
            override fun onResponse(
                call: Call<List<UserEntityDto>>,
                response: Response<List<UserEntityDto>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.map {
                        tempList.add(mapper.mapDtoToEntity(it))
                        callback.invoke(tempList)
                    }
                }
            }

            override fun onFailure(call: Call<List<UserEntityDto>>, t: Throwable) {
                throw RuntimeException("Server error")
            }

        })
    }
}