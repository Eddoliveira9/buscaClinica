package com.example.buscaclinica

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

import kotlinx.android.synthetic.main.activity_detalhar_user.*
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    private var mAuth : FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        btn_cadastrar.setOnClickListener {
            cadastrarView()

        }
        btn_login.setOnClickListener{
            login()
        }
    }

    fun login(){
        mAuth = FirebaseAuth.getInstance()
        mAuth?.signInWithEmailAndPassword(txt_email_login.text.toString(),txt_senha_login.text.toString())
            ?.addOnCompleteListener(this@Login){ task ->
                if(task.isSuccessful){
                    startActivity(Intent(applicationContext, CadastroUser::class.java))

                    //Toast.makeText(applicationContext, "Teste Login OK", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(applicationContext,"Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun cadastrarView(){

        startActivity(Intent(applicationContext, CadastroUser::class.java))
    }
}
