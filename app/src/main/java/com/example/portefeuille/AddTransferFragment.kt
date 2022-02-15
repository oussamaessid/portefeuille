package com.example.portefeuille

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.portefeuille.databinding.FragmentAddTransferBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add_transfer.*
import kotlinx.android.synthetic.main.fragment_add_transfer.amount
import kotlinx.android.synthetic.main.fragment_transfert.*


class AddTransferFragment : Fragment() {


    private var _binding: FragmentAddTransferBinding? = null
    private val binding get() = _binding!!
    private lateinit var database: DatabaseReference
    val trans = TransfertFragment()


    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddTransferBinding.inflate(inflater, container, false)


//            val phone : String = binding.etphone.text.toString()
            val userName  = binding.amount.text.toString()

            readData(userName)
//                read(phone)


        

        binding.readdataBtn.setOnClickListener {


            val montant = binding.etmontant.text.toString().toDouble()
            val valeur = binding.amount.text.toString().toDouble()
            val transfer = binding.txtAmount.text.toString().toDouble()


            if (valeur >= montant) {
                val result = valeur.minus(montant)
                binding.amount.setText(result.toString())
                val transferamount = transfer.plus(montant)
                binding.txtAmount.setText(transferamount.toString())


            } else {
                val snackbar = Snackbar.make(amount, "amount field reqired", Snackbar.LENGTH_SHORT)
                snackbar.show()

                snackbar.setAction("ok") {
                    Toast.makeText(
                        activity as AppCompatActivity,
                        "action trigger",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }


        return binding.root

    }


    private fun readData(nbphone: String) {

        database = FirebaseDatabase.getInstance().getReference("Users")

        database.child(nbphone).get().addOnSuccessListener {

            if(it.exists()) {
                val amount = it.child("amount").value
//                val phone = it.child("nbphone").value
                Toast.makeText(
                    activity as AppCompatActivity,
                    "Successfuly Updated",
                    Toast.LENGTH_SHORT
                )
                    .show()

                binding.amount.text = amount.toString()



            }
        }.addOnFailureListener {

            Toast.makeText(activity as AppCompatActivity, "Failed", Toast.LENGTH_SHORT).show()


        }

    }


}
