package com.like_magic.gitapp.data

import com.like_magic.gitapp.data.database.UserDbModel
import com.like_magic.gitapp.domain.dto.UserEntityDto
import com.like_magic.gitapp.domain.dto.UserRepoEntityDto
import com.like_magic.gitapp.domain.entity.UserEntity
import com.like_magic.gitapp.domain.entity.UserRepoEntity

class Mapper {

    fun mapDtoToEntity(userEntityDto: UserEntityDto) =
        UserEntity(userEntityDto.login, userEntityDto.id, userEntityDto.avatarUrl, userEntityDto.reposUrl)

    fun mapDbModelToUserEntity(userDbModel: UserDbModel) =
        UserEntity(userDbModel.login, userDbModel.id, userDbModel.avatarUrl, userDbModel.reposUrl)

    fun mapListDtoToListEntity(list: List<UserEntityDto>) =
        list.map {
            mapDtoToEntity(it)
        }

    fun mapRepoDtoToEntity(userRepoEntityDto: UserRepoEntityDto) =
        UserRepoEntity(userRepoEntityDto.id, userRepoEntityDto.name, userRepoEntityDto.forks, userRepoEntityDto.url)


    fun mapListEntityDtoToListDbModel(list: List<UserEntityDto>) =
        list.map {
            mapEntityDtoToDbModel(it)
        }

    private fun mapEntityDtoToDbModel(userEntityDto: UserEntityDto) =
        UserDbModel(userEntityDto.login, userEntityDto.id, userEntityDto.avatarUrl, userEntityDto.reposUrl)

}