package com.ndirawan.daily.model

import com.google.gson.annotations.SerializedName

data class Todos(

	@SerializedName("id")
	val id: Int? = null,

	@SerializedName("completed")
	val completed: Boolean? = null,

	@SerializedName("title")
	val title: String? = null,

	@SerializedName("userId")
	val userId: Int? = null
)
