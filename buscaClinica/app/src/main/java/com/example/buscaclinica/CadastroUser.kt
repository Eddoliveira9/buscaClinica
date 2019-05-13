package com.example.buscaclinica

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_cadastro_user.*

class CadastroUser : AppCompatActivity() {



    //pegar instancia do firebase, se for fazer tirar
    //private var mAuth : FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_user)
        //esse é para pegar o id da imagem no botão pedir foto
        //imagem = (imageView) findViewBuId(R.id.imageView)
        //Button galeria = (button) findViewById(R.id.btnPedirFoto)




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

}
