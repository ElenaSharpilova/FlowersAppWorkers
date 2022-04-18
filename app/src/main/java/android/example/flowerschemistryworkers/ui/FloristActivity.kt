package android.example.flowerschemistryworkers.ui

import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.databinding.ActivityFloristBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class FloristActivity : AppCompatActivity() {
    lateinit var binding: ActivityFloristBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_FlowersChemistryWorkers) //запуск Splash screen
        binding = ActivityFloristBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupBottomNavigationView()
        //binding.bottomNavigationViewFlorist.setupWithNavController(findNavController(R.id.fragmentContainerView))

    }

    private fun setupBottomNavigationView() {
        val supportFragManagerr = supportFragmentManager.findFragmentById(R.id.fragmentContainerViewFlorist) as NavHostFragment
        val navController : NavController = supportFragManagerr.navController
        findViewById<BottomNavigationView>(R.id.bottomNavigationView_florist)
            .setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.constructorBouquetFragment -> showBottomNav()
                R.id.profileFloristFragment -> showBottomNav()
                R.id.addBouquetFragment -> showBottomNav()
                R.id.myBouquetFragment -> showBottomNav()
                else -> hideBottomNav()
            }
        }
    }

    private fun showBottomNav() {
        binding.bottomNavigationViewFlorist.visibility = View.VISIBLE

    }

    private fun hideBottomNav() {
        binding.bottomNavigationViewFlorist.visibility = View.GONE

    }
}