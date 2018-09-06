package com.models


data class User(var id: Int, var userName: String, var userSecondName: String) {
    var mId: Int? = id
    var mUserName: String? = userName
    var mUserSecondName: String? = userSecondName
}