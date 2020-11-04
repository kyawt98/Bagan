package com.kyawt.baganmap.view.ui.bottomNav

import android.app.ActionBar
import android.app.AlarmManager
import android.app.AlertDialog
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.*
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.kyawt.baganmap.R
import com.kyawt.baganmap.utils.MyPreferences
import com.kyawt.baganmap.view.exts.visible
import com.skydoves.powerspinner.*
import kotlinx.android.synthetic.main.fragment_setting.*
import kotlinx.android.synthetic.main.fragment_setting.view.*
import java.util.*

class SettingFragment : Fragment() {
    lateinit var locale: Locale
    private var currentLanguage = "en"
    private var currentLang: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupLanguage()
        onPressedCards()
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        if (currentLanguage == "en"){
//            spinnerLanguage.hint = "English"
//        }
//        if (currentLanguage == "mm"){
//            spinnerLanguage.hint = "Myanmar"
//        }
//
//        else {
//            spinnerLanguage.hint = "English"
//        }
//    }

    private fun onPressedCards() {
        cardAbout.setOnClickListener {
            findNavController().navigate(
                R.id.action_settingFragment_to_aboutFragment,
                null,
                navOptions()
            )
        }
        cardPrivacy.setOnClickListener {
            findNavController().navigate(
                R.id.action_settingFragment_to_privacyFragment,
                null,
                navOptions()
            )
        }

    }

    private fun navOptions() = NavOptions.Builder()
        .setEnterAnim(R.anim.nav_default_enter_anim)
        .setExitAnim(R.anim.nav_default_exit_anim)
        .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
        .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
        .build()

    private fun setupLanguage(){
        val mySpinnerView = createPowerSpinnerView(requireContext()) {
            setSpinnerPopupWidth(300)
            setSpinnerPopupHeight(350)
            setArrowPadding(6)
            setArrowAnimate(true)
            setArrowAnimationDuration(200L)
            setArrowGravity(SpinnerGravity.START)
            setArrowTint(ContextCompat.getColor(requireContext(), R.color.md_200))
            setSpinnerPopupAnimation(SpinnerAnimation.BOUNCE)
            setShowDivider(true)
            setDividerColor(Color.WHITE)
            setDividerSize(2)
            setLifecycleOwner(this@SettingFragment)
            powerSpinnerView.show() // show the spinner popup
//            powerSpinnerView.showOrDismiss()

            spinnerLanguage.setOnSpinnerItemSelectedListener(
                OnSpinnerItemSelectedListener<IconSpinnerItem> { _, item ->
                    Toast.makeText(requireContext(), item.text, Toast.LENGTH_SHORT).show()
                }
            )
            spinnerLanguage.setOnSpinnerItemSelectedListener<String> { index, _ ->
               spinnerLanguage.lifecycleOwner = this@SettingFragment
                when (index) {
                    0 -> setLocale("en")
                    1 -> setLocale("mm")
                }
            }
//            spinnerLanguage.dismissWhenNotifiedItemSelected = true
//            spinnerLanguage.disableChangeTextWhenNotified = true
//            powerSpinnerView.dismiss() // dismiss the spinner popup
        }
    }

    private fun setLocale(localeName: String) {
        if (localeName != currentLanguage) {
            locale = Locale(localeName)
            val res = resources
            val dm = res.displayMetrics
            val conf = res.configuration
            conf.locale = locale
            res.updateConfiguration(conf, dm)

        } else {
            locale = Locale(currentLanguage)
            val res = resources
            val dm = res.displayMetrics
            val conf = res.configuration
            conf.locale = locale
            res.updateConfiguration(conf, dm)
        }
        restartSelf()
    }

    private fun restartSelf() {
        LoadingBar.visible()

        val am =
            requireActivity().getSystemService(Context.ALARM_SERVICE) as AlarmManager
        am[AlarmManager.RTC_WAKEUP, Calendar.getInstance().timeInMillis + 500] =
            PendingIntent.getActivity(
                activity, 0, requireActivity().intent, PendingIntent.FLAG_ONE_SHOT
                        or PendingIntent.FLAG_CANCEL_CURRENT
            )
        val i = requireActivity().baseContext.packageManager
            .getLaunchIntentForPackage(requireActivity().baseContext.packageName)
        i!!.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(i)
    }

}

