package android.example.flowerschemistryworkers.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.databinding.FragmentAddBouquetBinding
import android.example.flowerschemistryworkers.databinding.FragmentProfileBinding
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager

class AddBouquetFragment : Fragment() {
    private var _binding: FragmentAddBouquetBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddBouquetBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.imBtnBack.setOnClickListener {
            findNavController().navigate(R.id.action_addBouquetFragment_to_constructorBouquetFragment)
        }


        return view

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}