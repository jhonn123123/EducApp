package com.example.educapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class multiplicaciones : AppCompatActivity() {

    val manzanas= arrayListOf(R.drawable.numero_0,R.drawable.one_obj,R.drawable.two_obj,R.drawable.three_obj,R.drawable.four_obj,R.drawable.five_obj,R.drawable.six_obj,R.drawable.seven_obj,R.drawable.eigth_obj,R.drawable.nine_obj,R.drawable.ten_obj)
    val rt2=arrayListOf(R.drawable.numero_2,R.drawable.numero_4,R.drawable.numero_6,R.drawable.numero_8,R.drawable.numero_10,R.drawable.twelve,R.drawable.fourteen,R.drawable.sixteen,R.drawable.eighteen,R.drawable.twenty)
    val rt1= arrayListOf(R.drawable.numero_1,R.drawable.numero_2,R.drawable.numero_3,R.drawable.numero_4,R.drawable.numero_5,R.drawable.numero_6,R.drawable.numero_7,R.drawable.numero_8,R.drawable.numero_9,R.drawable.numero_10)
    val rt3= arrayListOf(R.drawable.numero_3,R.drawable.numero_6,R.drawable.numero_9,R.drawable.twelve,R.drawable.fiveteen,R.drawable.eighteen,R.drawable.twenty_one,R.drawable.twenty_four,R.drawable.twenty_seven,R.drawable.thirty)
    val rt4=arrayListOf(R.drawable.numero_4,R.drawable.numero_8,R.drawable.twelve,R.drawable.sixteen,R.drawable.twenty,R.drawable.twenty_four,R.drawable.twenty_eight,R.drawable.thirty_two,R.drawable.thirty_six,R.drawable.fourty)
    val rt5=arrayListOf(R.drawable.numero_5,R.drawable.numero_10,R.drawable.fiveteen,R.drawable.twenty,R.drawable.twenty_five,R.drawable.thirty,R.drawable.thirty_five,R.drawable.fourty,R.drawable.fourty_five,R.drawable.fifty)
    val rt6=arrayListOf(R.drawable.numero_6,R.drawable.twelve,R.drawable.eighteen,R.drawable.twenty_four,R.drawable.thirty,R.drawable.thirty_six,R.drawable.fourty_two,R.drawable.fourty_eight,R.drawable.fifty_four,R.drawable.sixty)
    val rt7=arrayListOf(R.drawable.numero_7,R.drawable.fourteen,R.drawable.twenty_one,R.drawable.twenty_eight,R.drawable.thirty_five,R.drawable.fourty_two,R.drawable.fourty_nine,R.drawable.fifty_six,R.drawable.sixty_three,R.drawable.seventy)
    val rt8=arrayListOf(R.drawable.numero_8,R.drawable.sixteen,R.drawable.twenty_four,R.drawable.thirty_two,R.drawable.fourty,R.drawable.fourty_eight,R.drawable.fifty_six,R.drawable.sixty_four,R.drawable.seventy_two,R.drawable.eighty)
    val rt9=arrayListOf(R.drawable.numero_9,R.drawable.eighteen,R.drawable.twenty_seven,R.drawable.thirty_six,R.drawable.fourty_five,R.drawable.fifty_four,R.drawable.sixty_three,R.drawable.seventy_two,R.drawable.eighty_one,R.drawable.ninety)
    val rt10=arrayListOf(R.drawable.numero_10,R.drawable.twenty,R.drawable.thirty,R.drawable.fourty,R.drawable.fifty,R.drawable.sixty,R.drawable.seventy,R.drawable.eighty,R.drawable.ninety,R.drawable.one_hundred)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiplicaciones)

        val obj: Intent=intent
        val n1=obj.getIntExtra("n",0)



        val app1=arrayListOf(findViewById<ImageView>(R.id.apple11),findViewById<ImageView>(R.id.apple12),findViewById<ImageView>(R.id.apple13),findViewById<ImageView>(R.id.apple14),findViewById<ImageView>(R.id.apple15),findViewById<ImageView>(R.id.apple16),findViewById<ImageView>(R.id.apple17),findViewById<ImageView>(R.id.apple18),findViewById<ImageView>(R.id.apple19),findViewById<ImageView>(R.id.apple110))
        val app2=arrayListOf(findViewById<ImageView>(R.id.apple21),findViewById<ImageView>(R.id.apple22),findViewById<ImageView>(R.id.apple23),findViewById<ImageView>(R.id.apple24),findViewById<ImageView>(R.id.apple25),findViewById<ImageView>(R.id.apple26),findViewById<ImageView>(R.id.apple27),findViewById<ImageView>(R.id.apple28),findViewById<ImageView>(R.id.apple29),findViewById<ImageView>(R.id.apple210))
        val result=arrayListOf(findViewById<ImageView>(R.id.rm1),findViewById<ImageView>(R.id.rm2),findViewById<ImageView>(R.id.rm3),findViewById<ImageView>(R.id.rm4),findViewById<ImageView>(R.id.rm5),findViewById<ImageView>(R.id.rm6),findViewById<ImageView>(R.id.rm7),findViewById<ImageView>(R.id.rm8),findViewById<ImageView>(R.id.rm9),findViewById<ImageView>(R.id.rm10))

        var r:Int =0

        when(n1){
            1 -> {
                for (i in 0..9)
                {
                    app1[i].setImageResource(manzanas[n1])
                    app2[i].setImageResource(manzanas[i+1])
                    r=n1*(i+1)
                    result[i].setImageResource(rt1[i])
                }
            }
            2 -> {
                for (i in 0..9)
                {
                    app1[i].setImageResource(manzanas[n1])
                    app2[i].setImageResource(manzanas[i+1])
                    result[i].setImageResource(rt2[i])
                }
            }
            3 -> {
                for (i in 0..9)
                {
                    app1[i].setImageResource(manzanas[n1])
                    app2[i].setImageResource(manzanas[i+1])
                    result[i].setImageResource(rt3[i])
                }
            }
            4 -> {
                for (i in 0..9)
                {
                    app1[i].setImageResource(manzanas[n1])
                    app2[i].setImageResource(manzanas[i+1])
                    result[i].setImageResource(rt4[i])
                }
            }
            5 -> {
                for (i in 0..9)
                {
                    app1[i].setImageResource(manzanas[n1])
                    app2[i].setImageResource(manzanas[i+1])
                    result[i].setImageResource(rt5[i])
                }
            }
            6 -> {
                for (i in 0..9)
                {
                    app1[i].setImageResource(manzanas[n1])
                    app2[i].setImageResource(manzanas[i+1])
                    result[i].setImageResource(rt6[i])
                }
            }
            7 -> {
                for (i in 0..9)
                {
                    app1[i].setImageResource(manzanas[n1])
                    app2[i].setImageResource(manzanas[i+1])
                    result[i].setImageResource(rt7[i])
                }
            }
            8 -> {
                for (i in 0..9)
                {
                    app1[i].setImageResource(manzanas[n1])
                    app2[i].setImageResource(manzanas[i+1])
                    result[i].setImageResource(rt8[i])
                }
            }
            9 -> {
                for (i in 0..9)
                {
                    app1[i].setImageResource(manzanas[n1])
                    app2[i].setImageResource(manzanas[i+1])
                    result[i].setImageResource(rt9[i])
                }
            }
            10 -> {
                for (i in 0..9)
                {
                    app1[i].setImageResource(manzanas[n1])
                    app2[i].setImageResource(manzanas[i+1])
                    result[i].setImageResource(rt10[i])
                }
            }
            /*in 4..10 -> {
                for (i in 0..9)
                {
                    app1[i].setImageResource(manzanas[n1])
                    app2[i].setImageResource(manzanas[i+1])
                    result[i].setImageResource(manzanas[i])
                }
            }*/
        }


        /*val ImageView1 = findViewById<ImageView>(R.id.apple11)
        val ImageView2 = findViewById<ImageView>(R.id.apple21)
        val ImageView3 = findViewById<ImageView>(R.id.rm1)

        var resource=manzanas[n1];
        var resource2=manzanas[1];
        var r=n1*1


        ImageView1.setImageResource(resource)
        ImageView2.setImageResource(resource2)
        ImageView3.setImageResource(manzanas[r])*/


    }
}