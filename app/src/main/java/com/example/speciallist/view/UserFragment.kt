package com.example.speciallist.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.speciallist.R
import com.example.speciallist.entity.UserResponse
import com.example.speciallist.util.replaceFragment
import com.example.speciallist.view.adapter.UserInformAdapter
import kotlinx.android.synthetic.main.fragment_user.*

class UserFragment:Fragment(),UserItemClickListener {

    private lateinit var userInformAdapter: UserInformAdapter
    companion object {
        @JvmStatic
        fun newInstance(data: List<UserResponse>) = UserFragment().apply {
            arguments = Bundle().apply {
                putParcelableArray("user_data", data.toTypedArray())
            }
        }
    }
    private var userInform: List<UserResponse>?=null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        userInform = arguments?.getParcelableArray("user_data")?.toList() as? List<UserResponse>
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
        userInformAdapter = UserInformAdapter(this)
        rvUserInform.layoutManager = LinearLayoutManager(activity)
        rvUserInform.adapter = userInformAdapter
        userInformAdapter.setUserInform(userInform)
    }

    override fun onItemClick(userDetailInform: UserResponse) {
        (activity as MainActivity).replaceFragment( R.id.fragment_container, UserDetailFragment.newInstance(userDetailInform),"userdetail")
    }
}