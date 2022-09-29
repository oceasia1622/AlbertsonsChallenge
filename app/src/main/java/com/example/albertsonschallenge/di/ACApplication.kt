package com.example.albertsonschallenge.di

import android.app.Application
import com.example.albertsonschallenge.di.module.NetworkModule
import com.example.albertsonschallenge.di.module.RepositoryModule

//class ACApplication: Application() {
//
//    override fun onCreate() {
//        super.onCreate()
//        component = DaggerACComponent.builder()
//            .coroutineModule(CoroutineModule())
//            .networkModule(NetworkModule())
//            .repositoryModule(RepositoryModule())
//            .contextModule(ContextModule(applicationContext))
//            .build()
//    }
//    companion object{
//        lateinit var component: ACComponent
//    }
//}