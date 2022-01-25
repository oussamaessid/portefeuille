package com.example.portefeuille

import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_service.*
import kotlinx.android.synthetic.main.fragment_service.view.*
import kotlinx.android.synthetic.main.fragment_sign_in.view.*


/**
 * A simple [Fragment] subclass.
 * Use the [ServiceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ServiceFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return  inflater.inflate(R.layout.fragment_service, container, false)




    }

}


