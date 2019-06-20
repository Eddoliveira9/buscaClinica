package com.projeto.buscaclinica.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.projeto.buscaclinica.R
import kotlinx.android.synthetic.main.activity_recuperar_senha.*
import com.projeto.buscaclinica.model.ValidateEmail

class RecuperarSenhaActivity : AppCompatActivity() {
    private var mAuth : FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar_senha)

        mAuth = FirebaseAuth.getInstance()

        btn_recuperar_senha.setOnClickListener { recuperarSenha() }
    }

    private fun recuperarSenha(){
        var campoValido = validarCampoEmail()

        if(campoValido)
            recuperarSenhaFirebase()
    }

    private fun validarCampoEmail(): Boolean {
        if (at_email?.text.isNullOrEmpty()) {
            at_email?.error = "Email obrigatório!"
            return false
        }else if(!ValidateEmail().validar(at_email?.text.toString())) {
            at_email?.error = "Email formato inválido!"
            return false
        }
        return true
    }

    private fun recuperarSenhaFirebase(){
        val mAuth = FirebaseAuth.getInstance()
        mAuth?.sendPasswordResetEmail(at_email.text.toString())
            ?.addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    at_email.setText("")
                    Toast.makeText(
                        applicationContext, "Recuperação de acesso iniciada. Email enviado.",
                        Toast.LENGTH_SHORT
                    ).show()

                } else {
                    Toast.makeText(
                        applicationContext, "Falhou! Tente novamente",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}
