package com.example.speciallist.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.speciallist.dao.UserDAO
import com.example.speciallist.entity.SpecialtyResponse
import com.example.speciallist.entity.UserResponse
import com.example.speciallist.network.UserRepository
import com.example.speciallist.util.isOnline
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.stream.Collectors

class SpecialtyViewModel(
    private val repository: UserRepository,
    val context: Context,
    private val dao : UserDAO
): ViewModel() {

    val coroutineScope = CoroutineScope(Dispatchers.IO)

    val responseLiveData = MutableLiveData<Map<List<SpecialtyResponse>?,List<UserResponse>>>()

    fun getInformation() {
        coroutineScope.launch {
            val daoResponse = dao.getAllInform()
            if(daoResponse.isNotEmpty()){
                val specialtyList = daoResponse.groupBy { it.specialty }
                responseLiveData.postValue(specialtyList)
            }else{
                if(isOnline(context)){
                    val result = repository.getService().getUserInformation().response
                    if (result != null) {
                        dao.addInformation(result)
                        val specialtyList = dao.getAllInform().groupBy { it.specialty }
                        responseLiveData.postValue(specialtyList)
                    }
                }else{

                }
            }
        }
    }
}