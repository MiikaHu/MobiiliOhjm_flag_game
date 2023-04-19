package com.example.lippupeliv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class flagsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flags)

        val firstFragment = FirstFragment1()
        val fm: FragmentManager  = supportFragmentManager
        fm.beginTransaction().add(R.id.mainlayout,firstFragment).commit()

    }
}