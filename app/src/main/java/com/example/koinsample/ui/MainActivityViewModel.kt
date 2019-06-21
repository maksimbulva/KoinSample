package com.example.koinsample.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koinsample.Repository

class MainActivityViewModel(private val repository: Repository) : ViewModel() {

    val greetings: LiveData<String> = MutableLiveData<String>().apply {
        this.postValue(repository.getText())
    }
}