package com.kyawt.baganmap.view.ui.bottomNav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.kyawt.baganmap.R
import kotlinx.android.synthetic.main.fragment_feedback.*

class FeedbackFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feedback, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBackPressed()
        actionFeedback()
    }

    private fun onBackPressed() {
        icBack.setOnClickListener {
            findNavController().navigate(
                R.id.action_feedbackFragment_to_contactFragment,
                null,
                navOptions()
            )
        }
    }

    private fun actionFeedback() {
        btnSend.setOnClickListener {
            val username = etUsername.text.trim().toString()
            val email = etEmail.text.trim().toString()
            val phone = etPhone.text.trim().toString()
            val address = etAddress.text.trim().toString()
            val message = etDescription.text.trim().toString()

            when {
                username.isEmpty() -> {
                    etUsername.error = "Required"
                }
                email.isEmpty() -> {
                    etEmail.error = "Required"
                }
                phone.isEmpty() -> {
                    etPhone.error = "Required"
                }
                address.isEmpty() -> {
                    etAddress.error = "Required"
                }
                message.isEmpty() -> {
                    etDescription.error = "Required"
                }
                else -> {
                    Toast.makeText(context, "Successfully Sent ", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(
                        R.id.action_feedbackFragment_to_contactFragment,
                        null,
                        navOptions()
                    )
                }
            }
        }
    }

    private fun navOptions() = NavOptions.Builder()
        .setEnterAnim(R.anim.nav_default_enter_anim)
        .setExitAnim(R.anim.nav_default_exit_anim)
        .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
        .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
        .build()
}