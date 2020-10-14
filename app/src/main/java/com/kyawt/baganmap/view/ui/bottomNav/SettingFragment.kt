package com.kyawt.baganmap.view.ui.bottomNav

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kyawt.baganmap.R
import com.kyawt.baganmap.view.exts.gone
import com.kyawt.baganmap.view.exts.visible
import kotlinx.android.synthetic.main.fragment_setting.*
import java.util.*
import kotlin.system.exitProcess


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
        currentLanguage = currentLang.toString()
        val list = ArrayList<String>()
        list.add("Select Language")
        list.add("English")
        list.add("Myanmar")
        val adapter = ArrayAdapter(context!!, R.layout.support_simple_spinner_dropdown_item, list)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerLanguage.adapter = adapter
        spinnerLanguage.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> {
                    }
                    1 -> setLocale("en")
                    2 -> setLocale("mm")
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
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
            restartSelf()
        } else {
            Toast.makeText(
                context, "Language, , already, , selected)!", Toast.LENGTH_LONG
            ).show();
        }
    }

    private fun restartSelf() {
        val am =
            requireActivity().getSystemService(Context.ALARM_SERVICE) as AlarmManager
        am[AlarmManager.RTC_WAKEUP, Calendar.getInstance().timeInMillis + 1000] =
            PendingIntent.getActivity(
                activity, 0, requireActivity().intent, PendingIntent.FLAG_ONE_SHOT
                        or PendingIntent.FLAG_CANCEL_CURRENT
            )
        val i = requireActivity().baseContext.packageManager
            .getLaunchIntentForPackage(requireActivity().baseContext.packageName)
        i!!.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        LoadingBar.visible()
        startActivity(i)
    }

}

