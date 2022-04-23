package com.irfan.challengech5.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailModel (
    val nama :String,
    val detail : String,

        ): Parcelable