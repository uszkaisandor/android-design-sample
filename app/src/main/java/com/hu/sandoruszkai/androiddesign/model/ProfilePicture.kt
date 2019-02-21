package com.hu.sandoruszkai.androiddesign.model

import com.squareup.moshi.Json

class ProfilePicture(
    @Json(name = "large")
    var pictureUrl: String?
)
