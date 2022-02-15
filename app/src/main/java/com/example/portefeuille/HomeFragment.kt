package com.example.portefeuille

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.portefeuille.databinding.FragmentHomeBinding
import com.example.portefeuille.databinding.FragmentTransfertBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_transfert.*


class HomeFragment : Fragment() {


    private  var _binding: FragmentHomeBinding?=null
    private  val  binding get() = _binding!!
    private lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.btnAdd.setOnClickListener {

            val nb: String = binding.textView.text.toString()
            if (nb.isNotEmpty()) {

                readData(nb)

            } else {

                Toast.makeText(activity as AppCompatActivity, "PLease enter the id", Toast.LENGTH_SHORT).show()

            }

        }

        return binding.root
    }


    private fun readData(nb: String) {

        database = FirebaseDatabase.getInstance().getReference("User")
        database.child(nb).get().addOnSuccessListener {

            if (it.exists()) {

                val amounts = it.child("amount").value

                Toast.makeText(activity as AppCompatActivity, "Successfuly Read", Toast.LENGTH_SHORT).show()

                binding.etTxt.text = amounts.toString()


            } else {

                Toast.makeText(activity as AppCompatActivity, "User Doesn't Exist", Toast.LENGTH_SHORT).show()


            }

        }.addOnFailureListener {

            Toast.makeText(activity as AppCompatActivity, "Failed", Toast.LENGTH_SHORT).show()


        }

    }


}