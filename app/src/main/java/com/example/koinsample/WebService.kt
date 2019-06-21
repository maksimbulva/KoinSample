package com.example.koinsample

interface WebService {
    fun loadData(): String
}

class WebServiceImpl : WebService {
    override fun loadData(): String {
        return "Hello World"
    }
}