package com.example.gap.data.model.rquest

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class ContentRequest(
    val request: Request,
)  {
    data class Request(
        private val Order: String = "desc",
        private val OrderBy: String = "createdate",
        private val PageIndex: Int = 1,
        private val PageSize: Int = 100,
        private val RequestId: Any? = null,
        private val RequestType: Int = 2,
    )
}