package com.example.gap.data.model.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GetContent(
    val ContentID: Int,
    val ThumbImage: String,
    val Title: String,
    val ZoneID: Int,
    val LandscapeImage: String,
    val Summary: String
):Parcelable