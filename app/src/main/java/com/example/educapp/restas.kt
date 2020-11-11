package com.example.educapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_restas.*
import kotlinx.android.synthetic.main.activity_suma.*
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

        fun btnar(n1: Int,n2: Int){

            btn_ar2.setOnClickListener {
                val intent = Intent( this,AR::class.java)
                intent.putExtra("n1",n1)
                intent.putExtra("n2",n2)
                startActivity(intent)
            }
        }

        when (rn1){
            1 -> {rn2=Random.nextInt(0,1)
                var n2=numeros[rn2];
                ImageView2.setImageResource(n2)
                btnar(rn1,rn2)
            }
            2 -> {rn2=Random.nextInt(0,2)
                var n2=numeros[rn2];
                ImageView2.setImageResource(n2)
                btnar(rn1,rn2)
            }
            3 -> {rn2=Random.nextInt(0,3)
                var n2=numeros[rn2];
                ImageView2.setImageResource(n2)
                btnar(rn1,rn2)
            }
            4 -> {rn2=Random.nextInt(0,4)
                var n2=numeros[rn2];
                ImageView2.setImageResource(n2)
                btnar(rn1,rn2)
            }
            5 -> {rn2=Random.nextInt(0,5)
                var n2=numeros[rn2];
                ImageView2.setImageResource(n2)
                btnar(rn1,rn2)
            }
            6 -> {rn2=Random.nextInt(0,6)
                var n2=numeros[rn2];
                ImageView2.setImageResource(n2)
                btnar(rn1,rn2)
            }
            7 -> {rn2=Random.nextInt(0,7)
                var n2=numeros[rn2];
                ImageView2.setImageResource(n2)
                btnar(rn1,rn2)
            }
            8 -> {rn2=Random.nextInt(0,8)
                var n2=numeros[rn2];
                ImageView2.setImageResource(n2)
                btnar(rn1,rn2)
            }
            9 -> {rn2=Random.nextInt(0,9)
                var n2=numeros[rn2];
                ImageView2.setImageResource(n2)
                btnar(rn1,rn2)
            }
            10 -> {rn2=Random.nextInt(0,10)
                var n2=numeros[rn2];
                ImageView2.setImageResource(n2)
                btnar(rn1,rn2)
            }
        }


        ImageView1.setImageResource(n1)
    }
}