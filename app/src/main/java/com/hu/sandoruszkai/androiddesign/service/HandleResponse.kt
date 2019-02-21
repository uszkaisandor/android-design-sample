package com.hu.sandoruszkai.androiddesign.service

interface HandleResponse<in T> {
    fun onResponse(response: T)
    fun onError(error:Throwable)
}