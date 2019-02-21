package com.hu.sandoruszkai.androiddesign.model

import com.squareup.moshi.Json

class UserWrapper (
    @Json(name = "results")
    var users: List<User>
)