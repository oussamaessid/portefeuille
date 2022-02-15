package com.example.portefeuille

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.portefeuille.databinding.FragmentRechargeBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_recharge.*
import kotlinx.android.synthetic.main.fragment_recharge.view.*
import kotlinx.android.synthetic.main.fragment_transfert.view.*


/**
 * A simple [Fragment] subclass.
 * Use the [RechargeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RechargeFragment : Fragment() {

    private val tn="TN"
    private val cad="CAD"
    private val eur="EUR"
    private val usd="USD"
    private val cny="CNY"






    private  var _binding: FragmentRechargeBinding?=null
    private  val  binding get() = _binding!!

    val values = mapOf(
        cny to 0.750 ,
    cad to  2.2609,
    eur to 3.2781 ,
    usd  to  3.330,
      tn to 1.0
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        _binding = FragmentRechargeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment



        val listOfCountry = listOf(tn,cad,eur,usd,cny)
        val adapter = ArrayAdapter(activity as AppCompatActivity, R.layout.drop_down_list,listOfCountry)
        binding.spFromCurrency.setAdapter(adapter)
        binding.spToCurrency.setAdapter(adapter)

        binding.btnConvert.setOnClickListener {

            if (binding.etFrom.text.toString().isNotEmpty()){
                val amount = binding.etFrom.text.toString().toDouble()
                val fromvalue = values[spFromCurrency.text.toString()]
                val tovalue = values[spToCurrency.text.toString()]
                val result = amount.times(tovalue!!.div(fromvalue!!))
                binding.tvResult.setText(result.toString())
            }else {
              val snackbar =  Snackbar.make(spToCurrency,"amount field reqired",Snackbar.LENGTH_SHORT)
                  snackbar.show()

                snackbar.setAction("ok"){
                    Toast.makeText(activity as AppCompatActivity,"action trigger",Toast.LENGTH_SHORT).show()
                }

            }

        }
        return binding.root






    }

}



