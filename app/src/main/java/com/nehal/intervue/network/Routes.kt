package com.nehal.intervue.network

import com.nehal.intervue.model.McqResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface Routes {

    @GET("classes/mcq")
    suspend fun getPost(@QueryMap options: Map<String, String>) : McqResponse
}