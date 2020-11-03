package com.example.educapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_normal.*

class normal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal)
        var one=1;

        btn_m1.setOnClickListener {
            val intent = Intent( this,multiplicaciones::class.java)
            intent.putExtra("n",1)
            startActivity(intent)
        }
        btn_m2.setOnClickListener {
            val intent = Intent( this,multiplicaciones::class.java)
            intent.putExtra("n",2)
            startActivity(intent)
        }
        btn_m3.setOnClickListener {
            val intent = Intent( this,multiplicaciones::class.java)
            intent.putExtra("n",3)
            startActivity(intent)
        }
        btn_m4.setOnClickListener {
            val intent = Intent( this,multiplicaciones::class.java)
            intent.putExtra("n",4)
            startActivity(intent)
        }
        btn_m5.setOnClickListener {
            val intent = Intent( this,multiplicaciones::class.java)
            intent.putExtra("n",5)
            startActivity(intent)
        }
        btn_m6.setOnClickListener {
            val intent = Intent( this,multiplicaciones::class.java)
            intent.putExtra("n",6)
            startActivity(intent)
        }
        btn_m7.setOnClickListener {
            val intent = Intent( this,multiplicaciones::class.java)
            intent.putExtra("n",7)
            startActivity(intent)
        }
        btn_m8.setOnClickListener {
            val intent = Intent( this,multiplicaciones::class.java)
            intent.putExtra("n",8)
            startActivity(intent)
        }
        btn_m9.setOnClickListener {
            val intent = Intent( this,multiplicaciones::class.java)
            intent.putExtra("n",9)
            startActivity(intent)
        }
        btn_m10.setOnClickListener {
            val intent = Intent( this,multiplicaciones::class.java)
            intent.putExtra("n",10)
            startActivity(intent)
        }

    }
}