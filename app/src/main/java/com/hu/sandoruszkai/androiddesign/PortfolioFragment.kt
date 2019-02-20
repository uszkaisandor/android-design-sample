package com.hu.sandoruszkai.androiddesign

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class PortfolioFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_portfolio, container, false)
    }

    override fun getTitle(): Int {
        return R.string.portfolio
    }
}
