package com.example.gap.data.model.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Result(
    val GetContentList: List<GetContent>,
    val TotalPages: Int
):Parcelable