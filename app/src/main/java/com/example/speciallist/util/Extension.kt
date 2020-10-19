package com.example.speciallist.util

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.replaceFragment(containerId: Int, fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
                replace(containerId,fragment)
                commit()
            }
}