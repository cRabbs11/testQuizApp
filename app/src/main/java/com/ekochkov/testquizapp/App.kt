package com.ekochkov.testquizapp

import android.app.Application
import com.ekochkov.testquizapp.di.AppComponent
import com.ekochkov.testquizapp.di.DaggerAppComponent
import com.ekochkov.testquizapp.di.modules.DataModule
import com.ekochkov.testquizapp.di.modules.DomainModule

class App: Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        dagger = DaggerAppComponent.builder()
            .dataModule(DataModule(this))
            .domainModule(DomainModule())
            .build()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}