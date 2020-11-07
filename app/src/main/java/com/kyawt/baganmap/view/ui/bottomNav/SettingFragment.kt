package com.kyawt.baganmap.view.ui.bottomNav

import android.app.Activity
import android.app.AlarmManager
import android.app.AlertDialog
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import com.kyawt.baganmap.MainActivity
import com.kyawt.baganmap.R
import com.kyawt.baganmap.view.exts.visible
import com.skydoves.powerspinner.SpinnerAnimation
import com.skydoves.powerspinner.SpinnerGravity
import com.skydoves.powerspinner.createPowerSpinnerView
import kotlinx.android.synthetic.main.fragment_setting.*
import java.util.*
import kotlin.system.exitProcess


class SettingFragment(
) : Fragment() {
    lateinit var locale: Locale
    private var currentLanguage = "en"
    private var currentLang: String? = null

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
        return inflater.inflate(R.layout.fragment_setting, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupLanguage()
        onPressedCards()
        exitFromApp()
    }

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

        cardVersion.setOnClickListener {
        }

    }

    private fun navOptions() = NavOptions.Builder()
        .setEnterAnim(R.anim.nav_default_enter_anim)
        .setExitAnim(R.anim.nav_default_exit_anim)
        .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
        .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
        .build()

    private fun setupLanguage() {
        val mySpinnerView = createPowerSpinnerView(requireContext()) {
            setSpinnerPopupWidth(300)
            setSpinnerPopupHeight(400)
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
//            powerSpinnerView.showOrDismiss()

            spinnerLanguage.setOnSpinnerItemSelectedListener<String> { index, _ ->
                powerSpinnerView.show() // show the spinner popup
                spinnerLanguage.lifecycleOwner = this@SettingFragment
                when (index) {
                    0 -> {
                        setLocale("en")
                        saveLocale("en")
                    }
                    1 -> {
                        setLocale("mm")
                        saveLocale("mm")
                    }
                }
            }
        }

        mySpinnerView.disableChangeTextWhenNotified = false
        spinnerLanguage.setOnSpinnerDismissListener {
            mySpinnerView.dismiss()
        }
    }

    private fun saveLocale(lang: String?) {
        val langPref = "Language"
        val prefs: SharedPreferences = requireContext().getSharedPreferences(
            "CommonPrefs",
            Activity.MODE_PRIVATE
        )
        val editor = prefs.edit()
        editor.putString(langPref, lang)
        editor.apply()
    }

    private fun setLocale(localeName: String) {
        if (localeName != currentLanguage) {
            locale = Locale(localeName)
            val res = resources
            val dm = res.displayMetrics
            val conf = res.configuration
            conf.locale = locale
            res.updateConfiguration(conf, dm)
//            saveLocale(localeName)

        } else {
            locale = Locale(currentLanguage)
            val res = resources
            val dm = res.displayMetrics
            val conf = res.configuration
            conf.locale = locale
            res.updateConfiguration(conf, dm)
//            saveLocale(localeName)
        }
        restartSelf()
    }

    private fun restartSelf() {
        LoadingBar.visible()
        Handler().postDelayed({
            val mStartActivity = Intent(context, MainActivity::class.java)
            val mPendingIntentId = 123456
            val mPendingIntent = PendingIntent.getActivity(
                context,
                mPendingIntentId,
                mStartActivity,
                PendingIntent.FLAG_CANCEL_CURRENT
            )
            val mgr = requireContext().getSystemService(Context.ALARM_SERVICE) as AlarmManager
            mgr[AlarmManager.RTC, System.currentTimeMillis() + 100] = mPendingIntent

        }, 2000)

    }

    private fun exitFromApp() {
        cardExit.setOnClickListener {
            val alertDialog: AlertDialog.Builder = AlertDialog.Builder(
                context,
                R.style.AlertDialogCustom
            )
            alertDialog.setTitle(getString(R.string.confirm_your_action))
            alertDialog.setMessage(getString(R.string.confirm))
            alertDialog.setPositiveButton(
                getString(R.string.exit)
            ) { _, _ ->
                LoadingBar.visible()
                Handler().postDelayed({
                    activity?.finishAffinity()
                    exitProcess(0)
                }, 3000)
                Toast.makeText(context, "Exiting", Toast.LENGTH_LONG).show()
            }
            alertDialog.setNegativeButton(
                getString(R.string.cancel)
            ) { _, _ -> }
            val alert: AlertDialog = alertDialog.create()
            alert.setCanceledOnTouchOutside(false)
            alert.show()
        }
    }
}