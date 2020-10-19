package com.example.speciallist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.speciallist.R
import com.example.speciallist.util.replaceFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(R.id.fragment_container,SpecialtyFragment())
    }
}