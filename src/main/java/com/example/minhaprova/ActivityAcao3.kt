package com.example.minhaprova

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityAcao3 : AppCompatActivity(){

    lateinit var proximoButton: Button
    lateinit var anteriorButton: Button
    lateinit var tituloTextView: TextView
    lateinit var autorTextView: TextView
    lateinit var anoTextView: TextView
    lateinit var notaTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acao3)

        proximoButton =findViewById(R.id.proximo)
        anteriorButton = findViewById(R.id.anteriorButton)
        tituloTextView = findViewById(R.id.titulo)
        autorTextView = findViewById(R.id.autor)
        anoTextView = findViewById(R.id.ano)
        notaTextView=findViewById(R.id.nota2)

        val db = LivroDBOpener(this)
        var idChange = 1
        var livros = db.findAll()

        if(idChange > 1){
            anteriorButton.isEnabled = false
        }
        var livro = db.findById(idChange)

           tituloTextView.text = "Título: ${livro.nome}"
            autorTextView.text = "Autor: ${livro.autor}"
            anoTextView.text = "Ano: ${livro.ano}"
            notaTextView.text = "Nota: ${livro.nota}"

        anteriorButton.setOnClickListener() {
            if(idChange > 1){
                proximoButton.isEnabled = true
            }

            var livro = db.findById(--idChange)

                tituloTextView.text = "Título: ${livro.nome}"
                autorTextView.text = "Autor: ${livro.autor}"
                anoTextView.text = "Ano: ${livro.ano}"
                notaTextView.text = "Nota: ${livro.nota}"

            if(idChange == 1){
                anteriorButton.isEnabled = false
            }
        }
        proximoButton.setOnClickListener() {
            var livro = db.findById(++idChange)

                tituloTextView.text = "Título: ${livro.nome}"
                autorTextView.text = "Autor: ${livro.autor}"
                anoTextView.text = "Ano: ${livro.ano}"
                notaTextView.text = "Nota: ${livro.nota}"


            if(idChange == livros.size){
                proximoButton.isEnabled = false
            }

            if(idChange > 1){
                anteriorButton.isEnabled = true
            }
        }
    }
}