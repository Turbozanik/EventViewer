package com.data.repository.net.retrofit

import android.text.TextUtils
import com.data.*
import com.data.repository.net.exception.BaseException
import com.data.repository.net.exception.ClientException
import com.data.repository.net.exception.PaymentException
import com.data.repository.net.exception.TokenExpiredException
import com.google.gson.annotations.Expose

class BaseResponse<T> {

    private var EMPTY: BaseResponse<T> = BaseResponse()

    init {
        EMPTY.status = STATUS_ERROR
    }

    @Expose
    var status: Int = 0
    @Expose
    var message: List<String>? = null
    @Expose
    val token: String? = null
    @Expose
    protected val result: T? = null

    override fun toString(): String {
        return ("BaseResponse{"
                + "status=" + status + ", "
                + "message=" + message + ", "
                + "token=" + token + ", "
                + "result=" + result)
    }

    val empty: BaseResponse<T>
        get() {
            return EMPTY
        }

    fun hasToken(): Boolean {
        return !TextUtils.isEmpty(token)
    }

    val errorMessage: String
        get() {
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
    fun getBaseResponseResult(): T? {
        when (status) {
            STATUS_SUCCESS -> return result
            STATUS_PAYMENT_ERROR -> throw PaymentException(getAllErrorMessages())
            STATUS_TOKEN_EXPIRED -> throw TokenExpiredException(getAllErrorMessages())
            STATUS_ERROR -> throw ClientException(getAllErrorMessages())
            else -> throw BaseException(getAllErrorMessages())
        }
    }
}
