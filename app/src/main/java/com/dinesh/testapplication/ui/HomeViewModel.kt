package com.dinesh.testapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dinesh.testapplication.data.Book
import com.dinesh.testapplication.repositories.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val repository: BookRepository
): ViewModel() {

    private val _data: MutableLiveData<List<Book>> = MutableLiveData()
    val data: LiveData<List<Book>> = _data

    init {
        loadData()
    }
    private fun loadData() {
        viewModelScope.launch {
            _data.postValue(repository.getBookList())
        }
    }

}