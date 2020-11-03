package com.example.educapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class multiplicaciones : AppCompatActivity() {

    val manzanas= arrayListOf(R.drawable.numero_0,R.drawable.one_obj,R.drawable.two_obj,R.drawable.three_obj,R.drawable.four_obj,R.drawable.five_obj,R.drawable.six_obj,R.drawable.seven_obj,R.drawable.eigth_obj,R.drawable.nine_obj,R.drawable.ten_obj)
    /*val app1=arrayListOf(findViewById<ImageView>(R.id.apple11),findViewById<ImageView>(R.id.apple12),findViewById<ImageView>(R.id.apple13),findViewById<ImageView>(R.id.apple14),findViewById<ImageView>(R.id.apple15),findViewById<ImageView>(R.id.apple16),findViewById<ImageView>(R.id.apple17),findViewById<ImageView>(R.id.apple18),findViewById<ImageView>(R.id.apple19),findViewById<ImageView>(R.id.apple110))
    val app2=arrayListOf(findViewById<ImageView>(R.id.apple21),findViewById<ImageView>(R.id.apple22),findViewById<ImageView>(R.id.apple23),findViewById<ImageView>(R.id.apple24),findViewById<ImageView>(R.id.apple25),findViewById<ImageView>(R.id.apple26),findViewById<ImageView>(R.id.apple27),findViewById<ImageView>(R.id.apple28),findViewById<ImageView>(R.id.apple29),findViewById<ImageView>(R.id.apple210))
    val x=arrayListOf(findViewById<ImageView>(R.id.x1),findViewById<ImageView>(R.id.x2),findViewById<ImageView>(R.id.x3),findViewById<ImageView>(R.id.x4),findViewById<ImageView>(R.id.x5),findViewById<ImageView>(R.id.x6),findViewById<ImageView>(R.id.x7),findViewById<ImageView>(R.id.x8),findViewById<ImageView>(R.id.x9),findViewById<ImageView>(R.id.x10))
    val eq=arrayListOf(findViewById<ImageView>(R.id.eq1),findViewById<ImageView>(R.id.eq2),findViewById<ImageView>(R.id.eq3),findViewById<ImageView>(R.id.eq4),findViewById<ImageView>(R.id.eq5),findViewById<ImageView>(R.id.eq6),findViewById<ImageView>(R.id.eq7),findViewById<ImageView>(R.id.eq8),findViewById<ImageView>(R.id.eq9),findViewById<ImageView>(R.id.eq10))
    val result=arrayListOf(findViewById<ImageView>(R.id.rm1),findViewById<ImageView>(R.id.rm2),findViewById<ImageView>(R.id.rm3),findViewById<ImageView>(R.id.rm4),findViewById<ImageView>(R.id.rm5),findViewById<ImageView>(R.id.rm6),findViewById<ImageView>(R.id.rm7),findViewById<ImageView>(R.id.rm8),findViewById<ImageView>(R.id.rm9),findViewById<ImageView>(R.id.rm10))
*/



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiplicaciones)

        val obj: Intent=intent
        val n1=obj.getIntExtra("n",0)



        val app1=arrayListOf(findViewById<ImageView>(R.id.apple11),findViewById<ImageView>(R.id.apple12),findViewById<ImageView>(R.id.apple13),findViewById<ImageView>(R.id.apple14),findViewById<ImageView>(R.id.apple15),findViewById<ImageView>(R.id.apple16),findViewById<ImageView>(R.id.apple17),findViewById<ImageView>(R.id.apple18),findViewById<ImageView>(R.id.apple19),findViewById<ImageView>(R.id.apple110))
        val app2=arrayListOf(findViewById<ImageView>(R.id.apple21),findViewById<ImageView>(R.id.apple22),findViewById<ImageView>(R.id.apple23),findViewById<ImageView>(R.id.apple24),findViewById<ImageView>(R.id.apple25),findViewById<ImageView>(R.id.apple26),findViewById<ImageView>(R.id.apple27),findViewById<ImageView>(R.id.apple28),findViewById<ImageView>(R.id.apple29),findViewById<ImageView>(R.id.apple210))
        val x=arrayListOf(findViewById<ImageView>(R.id.x1),findViewById<ImageView>(R.id.x2),findViewById<ImageView>(R.id.x3),findViewById<ImageView>(R.id.x4),findViewById<ImageView>(R.id.x5),findViewById<ImageView>(R.id.x6),findViewById<ImageView>(R.id.x7),findViewById<ImageView>(R.id.x8),findViewById<ImageView>(R.id.x9),findViewById<ImageView>(R.id.x10))
        val eq=arrayListOf(findViewById<ImageView>(R.id.eq1),findViewById<ImageView>(R.id.eq2),findViewById<ImageView>(R.id.eq3),findViewById<ImageView>(R.id.eq4),findViewById<ImageView>(R.id.eq5),findViewById<ImageView>(R.id.eq6),findViewById<ImageView>(R.id.eq7),findViewById<ImageView>(R.id.eq8),findViewById<ImageView>(R.id.eq9),findViewById<ImageView>(R.id.eq10))
        val result=arrayListOf(findViewById<ImageView>(R.id.rm1),findViewById<ImageView>(R.id.rm2),findViewById<ImageView>(R.id.rm3),findViewById<ImageView>(R.id.rm4),findViewById<ImageView>(R.id.rm5),findViewById<ImageView>(R.id.rm6),findViewById<ImageView>(R.id.rm7),findViewById<ImageView>(R.id.rm8),findViewById<ImageView>(R.id.rm9),findViewById<ImageView>(R.id.rm10))
        var r:Int =0

        when(n1){
            1 -> {
                for (i in 0..9)
                {
                    app1[i].setImageResource(manzanas[n1])
                    app2[i].setImageResource(manzanas[i+1])
                    r=n1*(i+1)
                    result[i].setImageResource(manzanas[n1*(i+1)])
                }
            }
            in 2..10 -> {
                for (i in 0..9)
                {
                    app1[i].setImageResource(manzanas[n1])
                    app2[i].setImageResource(manzanas[i+1])
                    result[i].setImageResource(manzanas[i])
                }
            }
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