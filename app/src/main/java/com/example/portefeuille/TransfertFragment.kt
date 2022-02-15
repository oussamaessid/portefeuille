package com.example.portefeuille

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.portefeuille.databinding.FragmentTransfertBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_sign_in.view.*
import kotlinx.android.synthetic.main.fragment_transfert.*
import kotlinx.android.synthetic.main.fragment_transfert.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [TransfertFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TransfertFragment : Fragment() {

    private var _binding: FragmentTransfertBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTransfertBinding.inflate(inflater, container, false)
        val view = inflater.inflate(R.layout.fragment_transfert, container, false)

//        view.btn_user.setOnClickListener {
//            Navigation.findNavController(view).navigate(R.id.to_addTransferFragment)
//        }

        binding.btnUser.setOnClickListener {

                val nbphone = binding.etuser.text.toString()
                if (nbphone.isNotEmpty()) {
                    Dataa(nbphone)
                    val fragmentB = AddTransferFragment()
                    activity?.getSupportFragmentManager()?.beginTransaction()
                        ?.replace(R.id.fragment, fragmentB)
                        ?.commit()

                } else {
                    Toast.makeText(
                        activity as AppCompatActivity,
                        "verifier votre données",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }




        return binding.root


    }
        fun Dataa(nbphone: String) {
            var database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(nbphone).get().addOnSuccessListener {

                val phone = it.child("nbphone").value
                val amount = it.child("amount").value
                if (nbphone == phone ) {
                    Toast.makeText(activity as AppCompatActivity, "verified successfuly", Toast.LENGTH_SHORT).show()
//                    add.amount.text= amount.toString()


                } else {
                    Toast.makeText(activity as AppCompatActivity, " failed", Toast.LENGTH_SHORT).show()

                }
            }

        }




}