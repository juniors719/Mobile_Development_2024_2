package com.example.profileapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Inicializando componentes

        val profileImage = findViewById<ImageView>(R.id.profileImage)
        val nameText = findViewById<TextView>(R.id.nameText)
        val descriptionText = findViewById<TextView>(R.id.descriptionText)
        val currentJobText = findViewById<TextView>(R.id.currentJobText)
        val experienceLayout = findViewById<LinearLayout>(R.id.experienceLayout)

        // Definindo informações do perfil
        nameText.text = "Djalma Júnior"
        descriptionText.text = "Desenvolvedor de Software com 3 anos de experiência"
        currentJobText.text = "Emprego Atual: Desenvolvedor Android na Empresa XYZ"

        // Lista de experiências
        val experiences = listOf(
            "2022 - Atual: Desenvolvedor Android na Empresa XYZ",
            "2018 - 2022: Designer Gráfico na Empresa ABC",
            "2015 - 2018: Analista de Sistemas na Empresa DEF"
        )

        // Adicionando experiencias dinamicamente
        for (experience in experiences) {
            val textView = TextView(this)
            textView.text = experience
            textView.textSize = 16f
            experienceLayout.addView(textView)
        }

        profileImage.setOnClickListener {
            Toast.makeText(this, "Clicou no nome", Toast.LENGTH_SHORT).show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}