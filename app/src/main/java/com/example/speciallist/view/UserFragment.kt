package com.example.speciallist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.speciallist.R
import com.example.speciallist.entity.UserResponse

class UserFragment:Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(data: UserResponse) = UserFragment().apply {
            arguments = Bundle().apply {
                putParcelable("user_data", data)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}