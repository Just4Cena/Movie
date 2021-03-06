package com.example.gap.ui.main

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.gap.data.ContentRepository
import com.example.gap.data.model.response.GetContent

class MainViewModel @ViewModelInject constructor(
    private val repository: ContentRepository,
    @Assisted state: SavedStateHandle,
) :
    ViewModel() {



    val content: LiveData<PagingData<GetContent>> = repository.getContentResult("").cachedIn(viewModelScope)


}