package com.hu.sandoruszkai.androiddesign.service

import com.hu.sandoruszkai.androiddesign.model.UserWrapper
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {

    @GET("api")
    fun getUsers( @Query("results") userNumber: Int): Single<UserWrapper>
}