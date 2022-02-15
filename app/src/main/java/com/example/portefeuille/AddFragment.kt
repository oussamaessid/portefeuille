package com.example.portefeuille

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.portefeuille.databinding.FragmentAddBinding
import com.example.portefeuille.databinding.FragmentTransfertBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_transfert.view.*


class AddFragment : Fragment() {


    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    private lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddBinding.inflate(inflater, container, false)

        binding.registerBtn.setOnClickListener {


            val firstName = binding.firstName.text.toString()
            val lastName = binding.lastName.text.toString()
            val nbphone = binding.nbPhone.text.toString()
            val amount = binding.textAmount.text.toString()


            database = FirebaseDatabase.getInstance().getReference("Users")
            val User = User(firstName, lastName, nbphone, amount)
            database.child(nbphone).setValue(User).addOnSuccessListener {

                binding.firstName.text.clear()
                binding.lastName.text.clear()
                binding.nbPhone.text.clear()
                binding.textAmount.text.clear()

                Toast.makeText(
                    activity as AppCompatActivity,
                    "Successfully Saved",
                    Toast.LENGTH_SHORT
                ).show()

            }.addOnFailureListener {

                Toast.makeText(activity as AppCompatActivity, "Failed", Toast.LENGTH_SHORT).show()


            }


        }

        binding.updateBtn.setOnClickListener {

            val userName = binding.nbPhone.text.toString()
            val firstName = binding.firstName.text.toString()
            val lastName = binding.lastName.text.toString()
            val amount = binding.textAmount.text.toString()

            updateData(userName, firstName, lastName, amount)

        }
        return binding.root


    }
    private fun updateData(phone: String, firstName: String, lastName: String, amount: String) {

        database = FirebaseDatabase.getInstance().getReference("Users")
        val user = mapOf<String, String>(
            "firstName" to firstName,
            "lastName" to lastName,
            "amount" to amount
        )

        database.child(phone).updateChildren(user).addOnSuccessListener {

            binding.nbPhone.text.clear()
            binding.firstName.text.clear()
            binding.lastName.text.clear()
            binding.textAmount.text.clear()
            Toast.makeText(activity as AppCompatActivity, "Successfuly Updated", Toast.LENGTH_SHORT)
                .show()


        }.addOnFailureListener {

            Toast.makeText(activity as AppCompatActivity, "Failed to Update", Toast.LENGTH_SHORT)
                .show()

        }

    }


}