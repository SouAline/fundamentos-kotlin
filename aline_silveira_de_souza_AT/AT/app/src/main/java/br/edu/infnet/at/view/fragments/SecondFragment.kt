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
import br.edu.infnet.at.R
import br.edu.infnet.at.view.ListaActivity
import br.edu.infnet.at.view.MainActivity
import br.edu.infnet.at.view.NavHostActivity
import br.edu.infnet.at.viewmodel.SharedViewModel

class SecondFragment : Fragment() {

    lateinit var sharedViewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        val reiniciarButton = view.findViewById<Button>(R.id.button2)

        reiniciarButton.setOnClickListener {
            val intent = Intent(requireContext(), NavHostActivity::class.java)
            startActivity(intent)
        }

        return view
    }


}