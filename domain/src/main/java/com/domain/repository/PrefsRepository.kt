package com.domain.repository


interface PrefsRepository {

    fun saveUserEmail(email: String)

    fun saveUserPassword(password: String)

    fun getUserEmail(): String?

    fun getUserPassword(): String?

}