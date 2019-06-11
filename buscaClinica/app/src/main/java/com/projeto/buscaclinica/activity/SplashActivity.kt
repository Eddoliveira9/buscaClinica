package com.projeto.buscaclinica.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.projeto.buscaclinica.R
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        buttonPrevious.visibility = View.GONE

        buttonNext.setOnClickListener {
            canvasOnboarding.next { finish ->
                if (finish) {
                    val login = Intent(this@SplashActivity, LoginActivity::class.java)
                    startActivity(login)
                    finish()
                }
            }
        }

        buttonPrevious.setOnClickListener {
            canvasOnboarding.previous()
        }
    }
}
