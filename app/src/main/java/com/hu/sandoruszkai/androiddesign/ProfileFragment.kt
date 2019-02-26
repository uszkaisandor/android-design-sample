package com.hu.sandoruszkai.androiddesign

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //super.onViewCreated(view, savedInstanceState)
        viewPager?.let {
            val adapter = ViewPagerAdapter(childFragmentManager, requireActivity())
            viewPager.adapter = adapter
        }
        viewPagerIndicator.setViewPager(viewPager)
    }
}