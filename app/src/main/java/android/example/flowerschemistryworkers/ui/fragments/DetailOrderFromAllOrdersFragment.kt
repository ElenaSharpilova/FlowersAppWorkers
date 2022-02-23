package android.example.flowerschemistryworkers.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistryworkers.databinding.FragmentDetailOrderFromAllOrdersBinding

class DetailOrderFromAllOrdersFragment : Fragment() {
    private var _binding: FragmentDetailOrderFromAllOrdersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailOrderFromAllOrdersBinding.inflate(inflater, container, false)
        val view = binding.root

        return view

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}