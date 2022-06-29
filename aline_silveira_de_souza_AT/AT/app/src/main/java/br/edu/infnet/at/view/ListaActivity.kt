package br.edu.infnet.at.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.at.R
import br.edu.infnet.at.adapter.AdapterProduto
import br.edu.infnet.at.viewmodel.SharedViewModel

class ListaActivity : AppCompatActivity() {

    lateinit var sharedViewModel: SharedViewModel
    lateinit var produtosRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        setSupportActionBar(findViewById(R.id.toolbar2))
        sharedViewModel = ViewModelProvider(this).get(SharedViewModel::class.java)

        startRecyclerView()

        val comprar_button = findViewById<Button>(R.id.comprarButton)

        comprar_button.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(sharedViewModel.enderecoSuper)
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

        val avancar_button = findViewById<Button>(R.id.advanceButton)

        avancar_button.setOnClickListener {
            val intent = Intent(this, NavHostActivity::class.java)
            startActivity(intent)
        }

        val quantidade_produto = findViewById<TextView>(R.id.quantidadeProduto)

        sharedViewModel.currentNumber.observe(this, Observer {
            quantidade_produto.text = it.toString()
        })

        incrementText()
    }

    private fun incrementText(){
        val addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener {
            sharedViewModel.currentNumber.value = ++sharedViewModel.number
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){

            R.id.info_item -> Toast.makeText(
                this,
                R.string.info,
                Toast.LENGTH_LONG).show()
        }
        return true
    }

    private fun startRecyclerView() {
        val listaProdutos = sharedViewModel.listaProdutos

        produtosRecyclerView = findViewById(R.id.recyclerView_produtos)
        produtosRecyclerView.layoutManager = LinearLayoutManager(this)
        produtosRecyclerView.setHasFixedSize(true)
        produtosRecyclerView.adapter = AdapterProduto(this, listaProdutos)
    }
}
