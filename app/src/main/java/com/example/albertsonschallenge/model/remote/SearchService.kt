package com.example.albertsonschallenge.model.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {
    @GET(END_POINT)
    fun getAcronymList(
//        @Query(Q_ARGS) searchInput: String
    ): Call<SearchResponse>
}