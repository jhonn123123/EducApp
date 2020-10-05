package com.example.educapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_facil.*
import kotlinx.android.synthetic.main.activity_level.*

class facil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facil)

        btn_suma.setOnClickListener {
            val intent = Intent( this,suma::class.java)
            startActivity(intent)
        }
    }
}