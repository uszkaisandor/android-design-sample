package com.hu.sandoruszkai.androiddesign

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    abstract fun getTitle(): Int
}
