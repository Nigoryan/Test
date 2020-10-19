package com.example.speciallist.di

import com.example.speciallist.network.UserRepository
import org.koin.dsl.module

val repositoryModule = module{
    single {UserRepository}
}