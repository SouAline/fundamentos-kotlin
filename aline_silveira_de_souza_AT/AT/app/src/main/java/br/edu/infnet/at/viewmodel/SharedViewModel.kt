package br.edu.infnet.at.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.edu.infnet.at.data.*
import br.edu.infnet.at.model.Produto

class SharedViewModel : ViewModel() {

    val listaProdutos : MutableList<Produto> = mutableListOf(produto1, produto2,
                                                             produto3, produto4,
                                                             produto5, produto6,
                                                             produto7)

    val enderecoSuper = "https://www.zonasul.com.br/"

    var number = 0

    val currentNumber: MutableLiveData<Int> by lazy{
        MutableLiveData<Int>()
    }

}