package com.data.net.pojo

import com.google.gson.annotations.SerializedName


data class User(@SerializedName("id") val id: Int,
				@SerializedName("user_name") val userName: String,
				@SerializedName("user_second_name") val secondName: String)