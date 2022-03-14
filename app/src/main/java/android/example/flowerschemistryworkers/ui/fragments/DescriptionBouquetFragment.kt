package android.example.flowerschemistryworkers.ui.fragments

import android.example.flowerschemistryworkers.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistryworkers.databinding.FragmentDescriptionBouquetBinding
import androidx.navigation.fragment.findNavController

class DescriptionBouquetFragment : Fragment() {
    private var _binding: FragmentDescriptionBouquetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDescriptionBouquetBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.imBtnBack.setOnClickListener {
            findNavController().navigate(R.id.action_descriptionBouquetFragment_to_myBouquetFragment)
        }

        return view

    }
}