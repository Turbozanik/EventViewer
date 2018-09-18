package com.domain.repository


interface SharedPrefsRepository {

	fun saveUserEmail(email: String)

	fun saveUserPassword(password: String)

	fun getUserEmail(): String?

	fun getUserPassword(): String?

}