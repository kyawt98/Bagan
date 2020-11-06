package com.kyawt.baganmap.view.ui.bottomNav

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.kyawt.baganmap.R
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBackgroundColor()
    }

    private fun setupRecycler() {

    }

    private fun setupBackgroundColor() {
        layoutArticle?.setBackgroundColor(
            sharedPreferences.getInt(
                getString(R.string.BackgroundColorPickerPreference),
                ContextCompat.getColor(requireContext(), R.color.background)
            )
        )

    }


}