package com.example.gap.data.paging

import android.util.Log
import androidx.paging.PagingSource
import com.example.gap.data.api.ContentApi
import com.example.gap.data.model.response.ContentResponse
import com.example.gap.data.model.response.GetContent
import com.example.gap.data.model.rquest.ContentRequest
import retrofit2.HttpException
import java.io.IOException

const val CONTENT_STARTING_PAGE_INDEX = 1

class ContentPagingFactory(
    private val contentApi: ContentApi,
    private val query: String,
) : PagingSource<Int, GetContent>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GetContent> {
        val position = params.key ?: CONTENT_STARTING_PAGE_INDEX
        return try {
            val response =
                contentApi.getContent(ContentRequest(ContentRequest.Request(PageIndex = position)))
            val content = response.Result.GetContentList
            LoadResult.Page(data = content,
                prevKey = if (position == CONTENT_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (content.isEmpty()) null else position + 1)
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

}