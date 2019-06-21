package com.example.koinsample.ui

import com.example.koinsample.Repository

// Will be created by DI ("constructor injection"), no annotations needed.
class MainActivityPresenter(private val repository: Repository) {
    fun getText() = repository.getText()
}