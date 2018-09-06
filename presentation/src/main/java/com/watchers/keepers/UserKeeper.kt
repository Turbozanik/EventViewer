package com.watchers.keepers

import com.models.User
import javax.inject.Singleton

@Singleton
class UserKeeper {
    var user: User? = null
}