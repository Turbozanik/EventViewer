package com.utils

import android.text.TextUtils
import java.util.regex.Pattern


object ValidationUtils {

	fun validateEmail(email: String?): Boolean {
		return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(
				email).matches()
	}

	fun validatePassword(password: String?): Boolean {
		return !TextUtils.isEmpty(password) && Pattern.compile(
				"(?!^[0-9]*\$)(?!^[a-zA-Z]*\$)^([a-zA-Z0-9]{8,16})\$").matcher(password).matches()
	}

}