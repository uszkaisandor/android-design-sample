package com.hu.sandoruszkai.androiddesign

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_profile.*


class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        hideDefaultNavBar()
        setNavBarListeners()
        setFragment(ProfileFragment())
    }

    private fun setNavBarListeners() {
        navbarBottom.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_search -> {
                    setFragment(SearchFragment())
                }
                R.id.action_home -> {
                    setFragment(ProfileFragment())
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun hideDefaultNavBar() {
        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_LOW_PROFILE or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }
    }

    private fun setFragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.frameFragmentHolder, fragment)
        ft.commit()
    }

}