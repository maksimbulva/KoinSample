package com.example.koinsample

class App : android.app.Application() {

    override fun onCreate() {
        super.onCreate()
        initInjector()
    }
}