package android.example.flowerschemistryworkers.ui.fragments


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistryworkers.databinding.FragmentProfileBinding
import android.example.flowerschemistryworkers.ui.RegistrationActivity


class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
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