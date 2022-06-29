package br.edu.infnet.at.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import br.edu.infnet.at.R
import br.edu.infnet.at.viewmodel.SharedViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedViewModel = ViewModelProvider(this).get(SharedViewModel::class.java)

        val button = findViewById<Button>(R.id.iniciarButton)

        button.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}