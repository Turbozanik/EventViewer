package com.domain.repository

import com.domain.models.UserDto
import io.reactivex.Flowable

interface NetRepository {
    fun register(body: Map<String, String?>): Flowable<UserDto?>
    fun login(body: Map<String, String?>): Flowable<UserDto?>
}
