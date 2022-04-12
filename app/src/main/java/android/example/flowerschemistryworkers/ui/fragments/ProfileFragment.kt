package android.example.flowerschemistryworkers.ui.fragments


import android.content.Intent
import android.example.flowerschemistryworkers.UserPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistryworkers.databinding.FragmentProfileBinding
import android.example.flowerschemistryworkers.ui.RegistrationActivity
import android.util.Log
import android.widget.Toast


class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    lateinit var sharedPreferences: UserPreferences
    lateinit var name: String
    lateinit var number: String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root
        name = binding.name.text.toString()
        number = binding.phoneNumber.text.toString()
        sharedPreferences =  UserPreferences(requireContext())


        binding.btnExit.setOnClickListener {
            startActivity(Intent(requireContext(), RegistrationActivity::class.java))
        }
        val shareName = sharedPreferences.fetchUserName()
        name = shareName.toString()
        Log.i("MyLog", name)


        return view
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}