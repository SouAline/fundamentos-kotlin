package br.edu.infnet.at.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.at.R
import br.edu.infnet.at.model.Produto
import org.w3c.dom.Text

class AdapterProduto(private val context: Context, private val produtos: MutableList<Produto>):
    RecyclerView.Adapter<AdapterProduto.ProdutoViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val itemLista = LayoutInflater.from(context).inflate(R.layout.produtos_item, parent, false)
        val holder = ProdutoViewHolder(itemLista)
        return holder
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {

        holder.foto.setImageResource(produtos[position].foto)
        holder.nome.text = produtos[position].nome
        holder.descricao.text = produtos[position].descricao
        holder.preco.text = produtos[position].preco
        holder.quantidade.text = produtos[position].quantidade
    }

    override fun getItemCount(): Int = produtos.size

    inner class ProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val foto = itemView.findViewById<ImageView>(R.id.fotoProduto)
        val nome = itemView.findViewById<TextView>(R.id.nomeProduto)
        val descricao = itemView.findViewById<TextView>(R.id.descricaoProduto)
        val preco = itemView.findViewById<TextView>(R.id.precoProduto)
        val quantidade = itemView.findViewById<TextView>(R.id.quantidadeProduto)
        val adicionar = itemView.findViewById<ImageView>(R.id.addButton)
    }
}