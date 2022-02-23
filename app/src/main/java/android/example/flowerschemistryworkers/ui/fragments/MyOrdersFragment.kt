package android.example.flowerschemistryworkers.ui.fragments

import android.example.flowerschemistryworkers.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistryworkers.databinding.FragmentMyOrdersBinding
import androidx.navigation.Navigation

class MyOrdersFragment : Fragment() {
    private var _binding: FragmentMyOrdersBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyOrdersBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.button.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_myOrderFragment_to_detailOrderFromAllOrdersFragment)
        }

        return view

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}