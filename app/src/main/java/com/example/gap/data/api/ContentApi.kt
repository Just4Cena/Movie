package com.example.gap.data.api

import com.example.gap.data.model.response.ContentResponse
import com.example.gap.data.model.response.Result
import com.example.gap.data.model.rquest.ContentRequest
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ContentApi {
    @Headers("Content-Type: application/json")
    @POST("mobile/request.asmx/GetContentList")
    suspend fun getContent(@Body request: ContentRequest): ContentResponse
}