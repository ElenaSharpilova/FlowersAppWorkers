package android.example.flowerschemistryworkers.ui.fragments

import android.example.flowerschemistryworkers.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistryworkers.databinding.FragmentProfileBinding
import android.view.animation.Transformation
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.arrowBtn.setOnClickListener {
            if (binding.cardGroup.isVisible){
                TransitionManager.beginDelayedTransition(binding.baseCardview, AutoTransition())
                binding.cardGroup.visibility = View.GONE
                binding.arrowBtn.setImageResource(R.drawable.ic_arrow_down)
            } else {
                TransitionManager.beginDelayedTransition(binding.baseCardview, AutoTransition())
                binding.cardGroup.visibility = View.VISIBLE
                binding.arrowBtn.setImageResource(R.drawable.ic_arrow_up)
            }
        }

        return view

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}