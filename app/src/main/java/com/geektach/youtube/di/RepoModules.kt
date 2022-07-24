package com.geektach.youtube.di

import com.geektach.youtube.remote.Repository
import org.koin.dsl.module

val repoModules = module {
    single { Repository(get()) }

}