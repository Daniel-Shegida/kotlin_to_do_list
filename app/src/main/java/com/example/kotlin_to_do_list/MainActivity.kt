package com.example.kotlin_to_do_list

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

//war between kapt, binding, and mipmap just broke me, i will return after 2nd project
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val binding =ActivityMainBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)



        var r = Runnable {
            startActivity(Intent(this, ListActivity::class.java))
        }

        var hand = Handler()
        hand.postDelayed(r, 5000)

    }
}
