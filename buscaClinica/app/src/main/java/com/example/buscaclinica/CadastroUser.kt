package com.example.buscaclinica

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro_user.*
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_detalhar_user.*

class CadastroUser : AppCompatActivity() {



    //pegar instancia do firebase, se for fazer tirar
    private var mAuth : FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_user)
        //esse é para pegar o id da imagem no botão pedir foto
        //imagem = (imageView) findViewBuId(R.id.imageView)
        //Button galeria = (button) findViewById(R.id.btnPedirFoto)

        btn_salvar_user.setOnClickListener {
            salvar(getUser())
            //Toast.makeText(this@CadastroUser, "este", Toast.LENGTH_LONG).show()
        }

    btn_cancelar.setOnClickListener{
        startActivity(Intent(applicationContext, Login::class.java))
    }
}

    private fun  getUser() : UsuarioCadastro
    {
        var usuario = UsuarioCadastro(
            txt_nome_completo.text.toString(),
            txt_email.text.toString(),
            txt_idade.text.toString().toInt(),
            txt_sexo.text.toString(),
            txt_senha.text.toString())

        return usuario
    }

   private fun salvar(usuario: UsuarioCadastro) {




    }





        //pegar instancia do firebase, se for fazer tirar
        //mAuth = FirebaseAuth.getInstance()

/*        btnSalvarUser.setOnClickListener{saveFunc(editTextNomeCompleto.text.toString(),
            editTextEmail.text.toString(),
            editTextIdade.text.toString(),
            editTextSexo.text.toString(),
            editTextSenha.text.toString(),
            this@CadastroUser) }

        private fun saveFunc(nome:String,email:String,idade:String,sexo:String,senha:String,activity:Activity){
            //isso foi baseado em outros projetos, como eu ainda não sei como vai ficar a imagem parei aqui

        }*/

    }
