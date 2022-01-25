package com.example.portefeuille

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.portefeuille.databinding.FragmentRechargeBinding
import kotlinx.android.synthetic.main.fragment_recharge.view.*
import kotlinx.android.synthetic.main.fragment_transfert.view.*


/**
 * A simple [Fragment] subclass.
 * Use the [RechargeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RechargeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recharge, container, false)
    }

}
