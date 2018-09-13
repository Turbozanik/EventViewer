package com.data.transformers.user

import com.data.net.pojo.User
import com.data.transformers.Transformer
import com.domain.models.UserDto


class UserToUserDtoTransformer : Transformer<User, UserDto> {
	override fun transform(params: User): UserDto? {
		return UserDto(params.id, params.userName, params.secondName)
    }

}