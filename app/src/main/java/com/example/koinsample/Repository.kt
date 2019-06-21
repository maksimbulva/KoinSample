package com.example.koinsample

interface Repository {
    fun getText(): String
}

// Will be created by DI ("constructor injection"), no annotations needed.
class RepositoryImpl(private val webService: WebService) : Repository {
    override fun getText(): String {
        return webService.loadData()
    }
}