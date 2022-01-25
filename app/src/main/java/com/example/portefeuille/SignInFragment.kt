package com.example.portefeuille

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_sign_in.view.*


/**
 * A simple [Fragment] subclass.
 * Use the [SignInFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignInFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)

        view.btn_transfert.setOnClickListener { Navigation.findNavController(view).navigate(R.id.to_transfertFragment2) }
        view.btn_recharge.setOnClickListener { Navigation.findNavController(view).navigate(R.id.to_rechargeFragment) }

        return view
    }


}