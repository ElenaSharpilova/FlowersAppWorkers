package android.example.flowerschemistryworkers.ui

import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.databinding.ActivityFloristBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController

class FloristActivity : AppCompatActivity() {
    lateinit var binding: ActivityFloristBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFloristBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.bottomNavigationViewFlorist.setupWithNavController(findNavController(R.id.fragmentContainerView))

    }
}