package com.example.gap.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.gap.data.api.ContentApi
import com.example.gap.data.paging.ContentPagingFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ContentRepository @Inject constructor(
    private val contentApi: ContentApi,
) {
    fun getContentResult(query: String) =
        Pager(config = PagingConfig(pageSize = 10, maxSize = 100, enablePlaceholders = false),
            pagingSourceFactory = { ContentPagingFactory(contentApi, query) }).liveData
}