package com.kyawt.baganmap.view.ui.home.hotel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kyawt.baganmap.MainActivity
import com.kyawt.baganmap.R
import kotlinx.android.synthetic.main.activity_hotel_map.*

class HotelMapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_map)
        supportActionBar?.hide()
        btnBack.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}