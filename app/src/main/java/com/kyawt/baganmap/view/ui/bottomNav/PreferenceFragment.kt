/*
 * Copyright (C) 2018 skydoves
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kyawt.baganmap.view.ui.bottomNav

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.preference.PreferenceFragmentCompat
import com.kyawt.baganmap.MainActivity
import com.kyawt.baganmap.R
import com.kyawt.baganmap.utils.CustomFlag
import com.kyawt.baganmap.view.exts.visible
import com.skydoves.colorpickerpreference.ColorPickerPreference
import com.skydoves.colorpickerview.ColorPickerDialog
import com.skydoves.colorpickerview.flag.BubbleFlag
import com.skydoves.colorpickerview.flag.FlagMode
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener
import kotlinx.android.synthetic.main.fragment_setting.*

class PreferenceFragment : PreferenceFragmentCompat() {

  override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
    addPreferencesFromResource(R.xml.pref_settings)
    initColorPickerPreference()
  }

  /** customizes [ColorPickerPreference]'s [ColorPickerDialog]. */
  private fun initColorPickerPreference() {
    /** sets custom flag to the color picker. */
    val colorPickerPreferenceToolbar = findPreference<ColorPickerPreference>(
      requireContext().getString(R.string.ToolbarColorPickerPreference)
    )
    val colorPickerView = colorPickerPreferenceToolbar?.getColorPickerView()
    colorPickerView?.flagView = BubbleFlag(requireContext()).apply { flagMode = FlagMode.FADE }

    val colorPickerPreferenceBackground = findPreference<ColorPickerPreference>(
      requireContext().getString(R.string.BackgroundColorPickerPreference)
    )
    colorPickerPreferenceBackground?.getColorPickerView()?.flagView = CustomFlag(requireContext(), R.layout.layout_flag)
    colorPickerPreferenceBackground?.preferenceColorListener = ColorEnvelopeListener { envelope, _ ->
      Toast.makeText(requireContext(), "background color: #${envelope.hexCode} is selected", Toast.LENGTH_SHORT).show()
      restartSelf()
    }

  }

  private fun restartSelf() {
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

    }, 500)

  }
}
