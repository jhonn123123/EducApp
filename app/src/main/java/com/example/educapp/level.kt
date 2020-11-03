package com.example.educapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_level.*
import kotlinx.android.synthetic.main.activity_main.*

class level : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)

        btn_facil.setOnClickListener {
            val intent = Intent( this,facil::class.java)
            startActivity(intent)
        }

        btn_normal.setOnClickListener {
            val intent = Intent( this,normal::class.java)
            startActivity(intent)
        }
    }
}