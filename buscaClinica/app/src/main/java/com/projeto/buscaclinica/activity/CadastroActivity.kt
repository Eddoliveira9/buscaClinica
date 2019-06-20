package com.projeto.buscaclinica.activity

import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.projeto.buscaclinica.R
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {
    private var mAuth : FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        mAuth = FirebaseAuth.getInstance()

        bt_cadastrar.setOnClickListener { cadastrar() }
    }

    private fun cadastrar(){
        var camposValidos = validarCampos()

        if(camposValidos)
            cadastrarFirebase(et_email.text.toString(), et_senha.text.toString(), this@CadastroActivity)
    }

    private fun cadastrarFirebase(email:String, senha: String, activity: CadastroActivity){
        val mAuth = FirebaseAuth.getInstance()
        mAuth?.createUserWithEmailAndPassword(email,senha)
            ?.addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(applicationContext, MainActivity::class.java))

                } else {
                    Toast.makeText(
                        applicationContext, "Falha na criação.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    private fun validarCampos(): Boolean{

        if (et_email?.text.isNullOrEmpty()) {
            et_email?.error = "Email obrigatório!"
            return false
        }else if(et_senha?.text.isNullOrEmpty()) {
            et_senha?.error = "Senha obrigatória!"
            return false
        }else if(et_confirma_senha?.text.isNullOrEmpty()) {
            et_confirma_senha?.error = "Senha obrigatória!"
            return false
        }else if(!et_confirma_senha?.text.toString().equals(et_senha?.text.toString())) {
            et_senha?.error = "As senhas devem ser iguais!"
            et_senha.requestFocus()
            return false
        }

        return true
    }
}
