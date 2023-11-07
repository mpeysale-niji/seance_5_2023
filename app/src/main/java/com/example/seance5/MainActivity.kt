package com.example.seance5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener {

    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tabLayout = findViewById(R.id.tab_layout)

        tabLayout.addOnTabSelectedListener(this)

        displayFirstTab()

    }

    private fun displayFirstTab() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, BlankFragment.newInstance("", ""))
            .commit()
    }

    private fun displaySecondTab() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, SecondFragment.newInstance("", ""))
            .commit()
    }

    private fun onTabChanged(tab: TabLayout.Tab) {
        when (tab.position) {
            0 -> displayFirstTab()
            1 -> displaySecondTab()
        }
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        Log.i("Tab", "Selected")
        tab?.let {
            onTabChanged(it)
        }
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
        Log.i("Tab", "UnSelected")
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
        Log.i("Tab", "ReSelected")
        tab?.let {
            onTabChanged(it)
        }
    }
}