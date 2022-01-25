package com.example.portefeuille

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_transfert.view.*
git init

/**
 * A simple [Fragment] subclass.
 * Use the [TransfertFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TransfertFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_transfert, container, false)
        view.button.setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_transfertFragment2) }

        return view
    }

}