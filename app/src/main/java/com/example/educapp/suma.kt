package com.example.educapp

import android.content.Intent
import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import java.util.*
import kotlin.random.Random

class suma : AppCompatActivity() {


    val numeros= arrayListOf(R.drawable.numero_0,R.drawable.numero_1,R.drawable.numero_2,R.drawable.numero_3,R.drawable.numero_4,R.drawable.numero_5,R.drawable.numero_6,R.drawable.numero_7,R.drawable.numero_8,R.drawable.numero_9,R.drawable.numero_10);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suma)

        var rand=numeros[Random.nextInt(numeros.size)]
        val ImageView1 = findViewById<ImageView>(R.id.n1)
        val ImageView2 = findViewById<ImageView>(R.id.n2)


        var resource=numeros[Random.nextInt((numeros.size/2)+1)];
        var resource2=numeros[Random.nextInt((numeros.size/2)+1)];
        ImageView1.setImageResource(resource)
        ImageView2.setImageResource(resource2)


    }
}