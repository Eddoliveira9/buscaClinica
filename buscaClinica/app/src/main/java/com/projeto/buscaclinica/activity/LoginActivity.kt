package com.projeto.buscaclinica.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.projeto.buscaclinica.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    private var mAuth : FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        btn_entrar.setOnClickListener{login(edt_email.text.toString(),
                                            edt_senha.text.toString(),
                                            this@LoginActivity)}

        btn_cadastro.setOnClickListener{showCadastroActivity()}

        txv_recuperar_senha.setOnClickListener { resetarSenha() }
    }

    private fun resetarSenha(){
        startActivity(Intent(applicationContext, RecuperarSenhaActivity::class.java))
    }

    private fun showCadastroActivity(){
        startActivity(Intent(applicationContext, CadastroActivity::class.java))
    }

    private fun login(email:String, passW:String, activity: Activity) {

        var camposValidos = validarCampos()

        if(camposValidos)
            loginFirebase(email, passW, activity)
    }

    private  fun validarCampos(): Boolean {
        if (edt_email?.text.isNullOrEmpty()) {
            edt_email?.error = "Email obrigatório!"
            return false
        }else if(edt_senha?.text.isNullOrEmpty()) {
            edt_senha?.error = "senha obrigatória!"
            return false
        }
        return true
    }

    private fun loginFirebase(email:String, password:String, activity: Activity){

        val mAuth = FirebaseAuth.getInstance()
        mAuth?.signInWithEmailAndPassword(email,password)
            ?.addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(applicationContext, MainActivity::class.java))

                } else {
                    Toast.makeText(
                        applicationContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }


    //validar os campos de login
    //logar no firebase
    //criar um fragment para cadastro
    //validar os campos de cadastro
    //verificar se o usuário já está cadastrado
    //usar padrão strategy
    //chamar a tela de lista de clinicas

}
