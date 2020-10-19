package com.example.speciallist.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.speciallist.dao.UserDAO
import com.example.speciallist.entity.UserResponse
import com.example.speciallist.network.UserRepository
import com.example.speciallist.util.isOnline
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SpecialtyViewModel(
    private val repository: UserRepository,
    val context: Context,
    private val dao : UserDAO
): ViewModel() {

    val coroutineScope = CoroutineScope(Dispatchers.IO)

    val responseLiveData = MutableLiveData<List<UserResponse>>()

    fun getInformation() {
        coroutineScope.launch {
            if(isOnline(context)){
                val result = repository.getService().getUserInformation().response
                if (result != null) {
                    dao.addInformation(result)
                }
                responseLiveData.postValue(result)
            }else{
                val result = dao.getAllSpecialty()
                responseLiveData.postValue(result)
            }

        }
    }
}