package com.projeto.buscaclinica.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.projeto.buscaclinica.R


class Splash2s : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val background = object : Thread() {
            override fun run() {
                try {
                    sleep(2499)
                    startActivity(Intent(this@Splash2s, LoginActivity::class.java))
                    finish()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        background.start()


    }
}
