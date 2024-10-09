package com.cibertec.myciberapps04

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("getAll")
    fun getAllTourismPLaces(): Call< List<TourismPlace> >

    @GET("getById")
    fun getTourismPLaceById(
        @Query("id") id: String
    ): Call< TourismPlace >

}