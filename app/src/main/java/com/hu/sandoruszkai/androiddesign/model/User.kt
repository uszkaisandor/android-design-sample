package com.hu.sandoruszkai.androiddesign.model

import com.squareup.moshi.Json

data class User(
    var name: Name,
    @Json(name = "gender")
    var gender: String?,
    var picture: ProfilePicture
)