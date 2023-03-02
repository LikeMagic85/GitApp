package com.like_magic.gitapp.data

import com.like_magic.gitapp.domain.dto.UserEntityDto
import com.like_magic.gitapp.domain.entity.UserEntity

class Mapper {

    fun mapDtoToEntity(userEntityDto: UserEntityDto) =
        UserEntity(userEntityDto.login, userEntityDto.id, userEntityDto.avatarUrl)

}