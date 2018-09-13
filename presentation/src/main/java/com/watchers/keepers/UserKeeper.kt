package com.watchers.keepers

import com.domain.models.UserDto
import javax.inject.Singleton

@Singleton
class UserKeeper {
	var user: UserDto? = null
}