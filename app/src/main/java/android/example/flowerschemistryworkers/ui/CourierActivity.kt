package android.example.flowerschemistryworkers.ui

import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.databinding.ActivityCourierBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController


class CourierActivity : AppCompatActivity() {
    lateinit var binding: ActivityCourierBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_FlowersChemistryWorkers) //запуск Splash screen
        binding = ActivityCourierBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.bottomNavigationView.setupWithNavController(findNavController(R.id.fragmentContainerView))
        //setupBottomNavigationView()
    }

    /*private fun setupBottomNavigationView() {
        val navController = findNavController(R.id.fragmentContainerView)
        findViewById<BottomNavigationView>(R.id.bottomNavigationView)
            .setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.allOrdersFragment -> showBottomNav()
                R.id.myOrderFragment -> showBottomNav()
                R.id.profileFragment -> showBottomNav()
                R.id.detailOrderFromAllOrdersFragment -> showBottomNav()
                else -> hideBottomNav()
            }
        }
    }

    private fun showBottomNav() {
        binding.bottomNavigationView.visibility = View.VISIBLE
    }

    private fun hideBottomNav() {
        binding.bottomNavigationView.visibility = View.GONE
    }*/
}