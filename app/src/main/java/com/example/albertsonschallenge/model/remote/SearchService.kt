package com.example.albertsonschallenge.model.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {
    @GET(END_POINT)
    suspend fun getAcronymList(
        @Query(Q_ARGS) searchInput: String
    ): Response<SearchResponse>
}