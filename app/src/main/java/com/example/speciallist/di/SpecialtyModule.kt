package com.example.speciallist.di

import com.example.speciallist.viewmodel.SpecialtyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val specialtyModule = module {
    viewModel { SpecialtyViewModel(get(),get(), get()) }
}