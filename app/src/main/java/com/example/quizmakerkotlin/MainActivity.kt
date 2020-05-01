package com.example.quizmakerkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI


class MainActivity : AppCompatActivity() {
    private lateinit var quizViewModel: QuizViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        quizViewModel = ViewModelProviders.of(this).get(QuizViewModel::class.java)
        initNavigation()
    }

    private fun initNavigation(){
        val navController = findNavController(R.id.navHostFragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        NavigationUI.setupActionBarWithNavController(this, navController,appBarConfiguration)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navConroller = findNavController(R.id.navHostFragment)
        return when (item?.itemId){
            android.R.id.home -> {
                navConroller.navigateUp()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

}
