package com.example.speciallist.view

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.speciallist.dao.UserDAO
import com.example.speciallist.network.UserRepository
import com.example.speciallist.viewmodel.SpecialtyViewModel
import java.lang.IllegalArgumentException

class SpecialtyViewModelFactory(
    private val repository:UserRepository, val context: Context, val dao: UserDAO
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass == SpecialtyViewModel::class.java)
            SpecialtyViewModel(repository, context, dao) as T
        else
            throw IllegalArgumentException("Wrong ViewModel")
    }
}