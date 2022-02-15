package com.example.portefeuille

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragment)

//        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment,R.id.serviceFragment,R.id.roomFragment))
//        setupActionBarWithNavController(navController,appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController)

        toolbar.setNavigationOnClickListener {

            when (nav_view2.isVisible) {
                true -> nav_view2.isVisible = false
                else ->nav_view2.isVisible = true
            }
        }



        // toolbar menu
       toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.delete -> {
                    // Handle favorite icon press
                    Toast.makeText(this, " delete", Toast.LENGTH_LONG).show()

                    true
                }
                R.id.update -> {
                    // Handle search icon press
                    Toast.makeText(this, " update", Toast.LENGTH_LONG).show()

                    true
                }

                else -> false
            }

        }
    }
}