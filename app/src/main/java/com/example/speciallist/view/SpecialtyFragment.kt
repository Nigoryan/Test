package com.example.speciallist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.speciallist.R
import com.example.speciallist.entity.UserResponse
import com.example.speciallist.util.replaceFragment
import com.example.speciallist.view.adapter.SpecialtyAdapter
import com.example.speciallist.viewmodel.SpecialtyViewModel
import kotlinx.android.synthetic.main.fragment_spec.*
import org.koin.android.ext.android.inject

class SpecialtyFragment: Fragment(), ItemClickListener {
    private val viewModel by inject<SpecialtyViewModel>()
    private lateinit var specialtyAdapter : SpecialtyAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_spec, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            specialtyAdapter = SpecialtyAdapter(context, this)
            rvSpec.layoutManager = LinearLayoutManager(activity)
            rvSpec.adapter = specialtyAdapter
            viewModel.getInformation()
            viewModel.responseLiveData.observe(viewLifecycleOwner, Observer <List<UserResponse>> {
                specialtyAdapter.setSpecialization(it)
            })
    }

    override fun onItemClick(user: UserResponse) {
        (activity as MainActivity).replaceFragment( R.id.fragment_container, UserFragment.newInstance(user))
    }
}