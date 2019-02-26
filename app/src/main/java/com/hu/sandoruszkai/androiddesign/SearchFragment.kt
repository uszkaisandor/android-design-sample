package com.hu.sandoruszkai.androiddesign

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.hu.sandoruszkai.androiddesign.model.UserWrapper
import com.hu.sandoruszkai.androiddesign.service.HandleResponse
import com.hu.sandoruszkai.androiddesign.service.UserController
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getUsers()
        setRecyclerViewGridAdapter()
        recyclerViewHeader.attachTo(recyclerViewGrid)
    }

    private fun setRecyclerViewGridAdapter() {
        recyclerViewGrid?.layoutManager = GridLayoutManager(requireActivity(), 3)
        recyclerViewGrid?.setHasFixedSize(true)
        recyclerViewGrid?.adapter = UserAdapter(requireActivity(), ArrayList())
    }

    private fun getUsers() {
        UserController().getUsers(object : HandleResponse<UserWrapper> {
            override fun onResponse(response: UserWrapper) {
                if (response.users.isNotEmpty()) {
                    (recyclerViewGrid?.adapter as UserAdapter).setDataSet(response.users)
                    recyclerViewGrid?.adapter?.notifyDataSetChanged()
                }
                crossfade()
            }
            override fun onError(error: Throwable) {
                error.printStackTrace()
                Toast.makeText(requireActivity(), getString(R.string.error), Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun crossfade() {
        val animationTime = 500L

        recyclerViewGrid.apply {
            animate()
                .alpha(1f)
                .setDuration(animationTime)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        recyclerViewGrid?.visibility = View.VISIBLE
                    }
                })
        }
        progressBarCircular.animate()
            .alpha(0f)
            .setDuration(animationTime)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    progressBarCircular?.visibility = View.GONE
                }
            })
    }

}