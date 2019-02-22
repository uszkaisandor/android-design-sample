package com.hu.sandoruszkai.androiddesign

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter internal constructor(fm: FragmentManager, private val context: Context) :
    FragmentPagerAdapter(fm) {

    private val count = 2

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> PortfolioFragment()
            else -> AboutFragment()
        }
    }

    override fun getCount(): Int {
        return count
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.getString((getItem(position) as BaseFragment).getTitle())
    }
}