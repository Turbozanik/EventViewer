package com.data.net.retrofit

import android.text.TextUtils
import com.data.*
import com.data.net.exception.BaseException
import com.data.net.exception.ClientException
import com.data.net.exception.PaymentException
import com.data.net.exception.TokenExpiredException
import com.google.gson.annotations.Expose

class BaseResponse<T> {
	private val EMPTY
		get() = BaseResponse<T>()

	@Expose
	private val status: Int = 0
	@Expose
	var message: List<String>? = null
	@Expose
	private val token: String? = null
	@Expose
	private val result: T? = null

	override fun toString(): String {
		return ("BaseResponse{"
				+ "status=" + status + ", "
				+ "message=" + message + ", "
				+ "token=" + token + ", "
				+ "result=" + result)
	}

	fun empty(): BaseResponse<*> {
		return EMPTY
	}

	fun hasToken(): Boolean {
		return !TextUtils.isEmpty(token)
	}

	fun getErrorMessage(): String {
		return if (message != null && !message!!.isEmpty()) {
			message!![0]
		} else ""
	}

	private fun getAllErrorMessages(): String {
		return if (message != null && !message!!.isEmpty()) {
			TextUtils.join(SEPARATOR, message)
		} else ""
	}

	fun isTokenEmpty(): Boolean {
		return TextUtils.isEmpty(token) || token!!.trim { it <= ' ' } == "null"
	}

	@Throws(BaseException::class)
	fun getResult(): T? {
		when (status) {
			STATUS_SUCCESS -> return result
			STATUS_PAYMENT_ERROR -> throw PaymentException(getAllErrorMessages())
			STATUS_TOKEN_EXPIRED -> throw TokenExpiredException(getAllErrorMessages())
			STATUS_ERROR -> throw ClientException(getAllErrorMessages())
			else -> throw BaseException(getAllErrorMessages())
		}
	}
}
