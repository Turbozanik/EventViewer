package com.domain.repository

import com.domain.models.UserDto
import io.reactivex.Flowable

interface NetRepository {
    fun register(map: Map<String, String>): Flowable<UserDto?>
}
