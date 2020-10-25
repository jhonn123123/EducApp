package com.example.educapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlin.random.Random

class restas : AppCompatActivity() {
    val numeros= arrayListOf(R.drawable.numero_0,R.drawable.numero_1,R.drawable.numero_2,R.drawable.numero_3,R.drawable.numero_4,R.drawable.numero_5,R.drawable.numero_6,R.drawable.numero_7,R.drawable.numero_8,R.drawable.numero_9,R.drawable.numero_10);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restas)

        val ImageView1 = findViewById<ImageView>(R.id.r1)
        val ImageView2 = findViewById<ImageView>(R.id.r2)
        var rn1= Random.nextInt(1,11)
        var rn2= Random.nextInt((numeros.size))
        var n1=numeros[rn1];

        if (rn1==1){
            rn2=Random.nextInt(0,1)
            var n2=numeros[rn2];
            ImageView2.setImageResource(n2)
        }

        ImageView1.setImageResource(n1)
    }
}