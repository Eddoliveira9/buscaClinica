package br.com.iesb.projetoteste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetalharUser : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhar_user)

        editTextNomeCompleto.text = Editable.Factory.getInstance().newEditable("Jão da Silva")
        editTextEmail.text = Editable.Factory.getInstance().newEditable("jao@silva.com")
        editTextIdade.text = Editable.Factory.getInstance().newEditable("20")
        editTextSexo.text = Editable.Factory.getInstance().newEditable("Masculino")
        editTextSenha.text = Editable.Factory.getInstance().newEditable("senhaboa")
    }
}
