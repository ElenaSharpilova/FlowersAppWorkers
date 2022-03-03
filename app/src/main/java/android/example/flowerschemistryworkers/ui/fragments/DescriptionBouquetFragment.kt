package android.example.flowerschemistryworkers.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.adapters.SliderAdapter
import android.example.flowerschemistryworkers.databinding.FragmentDescriptionBouquetBinding
import androidx.navigation.fragment.findNavController
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations

class DescriptionBouquetFragment : Fragment() {
    private var _binding: FragmentDescriptionBouquetBinding? = null
    private val binding get() = _binding!!
    private var images = intArrayOf(R.drawable.image_slider1, R.drawable.image_slider2, R.drawable.image_slider3)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDescriptionBouquetBinding.inflate(inflater, container, false)
        val view = binding.root

        val sliderAdapter = SliderAdapter(images)
        binding.sliderView.setSliderAdapter(sliderAdapter)
        binding.sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM)
        binding.sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
        binding.sliderView.startAutoCycle()

        binding.imBtnBack.setOnClickListener { findNavController().navigateUp() }

        return view

    }
}