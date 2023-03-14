package com.like_magic.gitapp.data

import com.like_magic.gitapp.domain.dto.UserEntityDto
import com.like_magic.gitapp.domain.dto.UserRepoEntityDto
import com.like_magic.gitapp.domain.entity.UserEntity
import com.like_magic.gitapp.domain.entity.UserRepoEntity

class Mapper {

    fun mapDtoToEntity(userEntityDto: UserEntityDto) =
        UserEntity(userEntityDto.login, userEntityDto.id, userEntityDto.avatarUrl, userEntityDto.reposUrl)

    fun mapListDtoToListEntity(list: List<UserEntityDto>) =
        list.map {
            mapDtoToEntity(it)
        }

    fun mapRepoDtoToEntity(userRepoEntityDto: UserRepoEntityDto) =
        UserRepoEntity(userRepoEntityDto.id, userRepoEntityDto.name, userRepoEntityDto.forks, userRepoEntityDto.url)

    fun mapListRepoDtoToListRepoEntity(list:List<UserRepoEntityDto>) =
        list.map {
            mapRepoDtoToEntity(it)
        }


}