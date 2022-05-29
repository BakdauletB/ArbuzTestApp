package com.baha.arbuztestapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.baha.arbuztestapp.R
import com.baha.arbuztestapp.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragment()
    }

    private fun initFragment() {
        val homeFragment = HomeFragment.newInstance()
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.add(R.id.fragmentContainer, homeFragment, HomeFragment.TAG)
//        transaction.commit()
    }
}