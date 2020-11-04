package com.nehal.intervue.model

import com.google.gson.annotations.SerializedName

data class McqResponse(
		@SerializedName("results")
		val results: List<Mcq>? = null,

		@SerializedName("count")
		val count: Int? = null
)