package br.edu.infnet.at.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import br.edu.infnet.at.R
import br.edu.infnet.at.view.ListaActivity
import br.edu.infnet.at.viewmodel.SharedViewModel


class FirstFragment : Fragment() {

    lateinit var sharedViewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        val avancarButton = view.findViewById<Button>(R.id.faqButton)

        avancarButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_secondFragment)
        }

        val listaButton = view.findViewById<Button>(R.id.listarButton)

        listaButton.setOnClickListener {
            val intent = Intent(requireContext(), ListaActivity::class.java)
            startActivity(intent)
        }

        return view
    }

}