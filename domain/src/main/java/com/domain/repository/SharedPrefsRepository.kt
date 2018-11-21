package com.domain.repository

import io.reactivex.Flowable


interface SharedPrefsRepository {

    fun saveUserEmail(email: String?): Flowable<Any>

    fun saveUserPassword(password: String?): Flowable<Any>

    fun getUserEmail(): Flowable<String>

    fun getUserPassword(): Flowable<String>

}