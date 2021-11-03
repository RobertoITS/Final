package com.example.afinal

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class Adapter(private val context: Context, fm: FragmentManager,
              internal var totalTabs: Int): FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        return when (position){
            0 -> {
                LoginFragment()
            }
            1 -> {
                RegisterFragment()
            }
            else -> {
                null!!
            }

        }
    }
}