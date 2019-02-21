package com.hu.sandoruszkai.androiddesign.service

import com.hu.sandoruszkai.androiddesign.model.User
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class UserController {

    private val BASE_URL = "http://randomuser.me/"

    fun getUsers(): Single<List<User>> {

        val api: UserApi = ApiClient.getClient(HttpClientFactory.getClient(), BASE_URL)
            .create(UserApi::class.java)

        return api
            .getUsers(16)
            .subscribeOn(Schedulers.io())
            .map {
                it.users
            }
    }
}