package com.example.educapp

import android.content.Intent
import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_level.*
import kotlinx.android.synthetic.main.activity_suma.*
import java.util.*
import kotlin.random.Random
import kotlin.random.nextInt

class suma : AppCompatActivity() {


    val numeros= arrayListOf(R.drawable.numero_0,R.drawable.numero_1,R.drawable.numero_2,R.drawable.numero_3,R.drawable.numero_4,R.drawable.numero_5,R.drawable.numero_6,R.drawable.numero_7,R.drawable.numero_8,R.drawable.numero_9,R.drawable.numero_10);
    val manzanas= arrayListOf(R.drawable.numero_0,R.drawable.one_obj,R.drawable.two_obj,R.drawable.three_obj,R.drawable.four_obj,R.drawable.five_obj,R.drawable.six_obj,R.drawable.seven_obj,R.drawable.eigth_obj,R.drawable.nine_obj,R.drawable.ten_obj)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suma)

        var rand=numeros[Random.nextInt(numeros.size)]
        val ImageView1 = findViewById<ImageView>(R.id.n1)
        val ImageView2 = findViewById<ImageView>(R.id.n2)
        //val ImageView3 = findViewById<ImageView>(R.id.apple1)
        //val ImageView4 =findViewById<ImageView>(R.id.apple2)

        /*var rn1=Random.nextInt((numeros.size/2)+1)
        var rn2=Random.nextInt((numeros.size/2)+1)*/
        var rn1=Random.nextInt(numeros.size)
        var rn2=Random.nextInt((numeros.size))
        var resource=numeros[rn1];

        fun btnar(n1: Int,n2: Int){

            btn_ar.setOnClickListener {
                val intent = Intent( this,AR::class.java)
                intent.putExtra("n1",n1)
                intent.putExtra("n2",n2)
                startActivity(intent)
            }
        }

        when (rn1) {
            0 -> {rn2=Random.nextInt(numeros.size)
                var resource2=numeros[rn2];
                ImageView2.setImageResource(resource2)
                btnar(rn1,rn2)
            }
            1 -> {rn2=Random.nextInt(0,10)
                var resource2=numeros[rn2];
                ImageView2.setImageResource(resource2)
                btnar(rn1,rn2)
            }
            2 -> {rn2=Random.nextInt(0,9)
                var resource2=numeros[rn2];
                ImageView2.setImageResource(resource2)
                btnar(rn1,rn2)
            }
            3 -> {rn2=Random.nextInt(0,8)
                var resource2=numeros[rn2];
                ImageView2.setImageResource(resource2)
                btnar(rn1,rn2)
            }
            4 -> {rn2=Random.nextInt(0,7)
                var resource2=numeros[rn2];
                ImageView2.setImageResource(resource2)
                btnar(rn1,rn2)
            }
            5 -> {rn2=Random.nextInt(0,6)
                var resource2=numeros[rn2];
                ImageView2.setImageResource(resource2)
                btnar(rn1,rn2)
            }
            6 -> {rn2=Random.nextInt(0,5)
                var resource2=numeros[rn2];
                ImageView2.setImageResource(resource2)
                btnar(rn1,rn2)
            }
            7 -> {rn2=Random.nextInt(0,4)
                var resource2=numeros[rn2];
                ImageView2.setImageResource(resource2)
                btnar(rn1,rn2)
            }
            8 -> {rn2=Random.nextInt(0,3)
                var resource2=numeros[rn2];
                ImageView2.setImageResource(resource2)
                btnar(rn1,rn2)
            }
            9 -> {rn2=Random.nextInt(0,2)
                var resource2=numeros[rn2];
                ImageView2.setImageResource(resource2)
                btnar(rn1,rn2)
            }
            10 -> {
                rn2=0
                var resource2=numeros[rn2];
                ImageView2.setImageResource(resource2)
                btnar(rn1,rn2)
            }
        }


        ImageView1.setImageResource(resource)


    }
}