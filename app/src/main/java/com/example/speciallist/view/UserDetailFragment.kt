package com.example.speciallist.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.speciallist.R
import com.example.speciallist.entity.UserResponse
import com.example.speciallist.util.capitalLetter
import com.example.speciallist.util.dateFormatter
import com.example.speciallist.util.dateToAge
import kotlinx.android.synthetic.main.fragment_user_detail.*

class UserDetailFragment: Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(data: UserResponse) = UserDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable("user_detail_data", data)
            }
        }
    }
    private var userDetailInform: UserResponse?=null
    override fun onAttach(context: Context) {
        super.onAttach(context)

        userDetailInform = arguments?.getParcelable("user_detail_data")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(context!!).load(userDetailInform?.avatar).into(ivAvatar)
        tvFName.text = capitalLetter(userDetailInform?.firstName)
        tvLName.text = capitalLetter(userDetailInform?.lastName)
        tvBDay.text = dateFormatter(userDetailInform?.birthday)
        val age = dateToAge(userDetailInform?.birthday)
        if(age!=null){
            tvAge.text = age.toString()
        }else{
            tvAge.text = "----"
        }
        tvSpecialty.text = userDetailInform?.specialty?.get(0)?.name


    }
}