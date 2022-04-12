package android.example.flowerschemistryworkers.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.databinding.FragmentProfileFloristBinding
import android.example.flowerschemistryworkers.ui.RegistrationActivity
import androidx.core.view.isVisible
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager

class ProfileFloristFragment : Fragment() {
    private var _binding: FragmentProfileFloristBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileFloristBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnExit.setOnClickListener {
            startActivity(Intent(requireContext(), RegistrationActivity::class.java))
        }
        return view

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}