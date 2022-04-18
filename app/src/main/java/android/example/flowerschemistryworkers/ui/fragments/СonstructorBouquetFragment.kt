package android.example.flowerschemistryworkers.ui.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.databinding.FragmentConstructorBouquetBinding
import android.graphics.Color
import android.icu.util.Calendar
import android.os.Build
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import java.text.SimpleDateFormat
import java.util.*

class СonstructorBouquetFragment : Fragment() {
    private var _binding: FragmentConstructorBouquetBinding? = null
    private val binding get() = _binding!!
    lateinit var tvDatePicker: TextView
    lateinit var btnDatePicker: CardView

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConstructorBouquetBinding.inflate(inflater, container, false)
        val view = binding.root

        val itemsFlowers = resources.getStringArray(R.array.flowers)
        val itemsCategories = resources.getStringArray(R.array.categories)
        val itemsLifecycleBouquet = resources.getStringArray(R.array.life_cycle_bouquet)

        val spinnerAdapterFlowers= object : ArrayAdapter<String>(requireContext(),android.R.layout.simple_spinner_item, itemsFlowers) {

            override fun isEnabled(position: Int): Boolean {
                return position != 0
            }

            override fun getDropDownView(
                position: Int,
                convertView: View?,
                parent: ViewGroup
            ): View {
                val view: TextView = super.getDropDownView(position, convertView, parent) as TextView
                if(position == 0) {
                    view.setTextColor(Color.GRAY)
                } else {
                    view.setTextColor(Color.BLACK)
                }
                return view
            }

        }

        val spinnerAdapterCategory= object : ArrayAdapter<String>(requireContext(),android.R.layout.simple_spinner_item, itemsCategories) {

            override fun isEnabled(position: Int): Boolean {
                return position != 0
            }

            override fun getDropDownView(
                position: Int,
                convertView: View?,
                parent: ViewGroup
            ): View {
                val view: TextView = super.getDropDownView(position, convertView, parent) as TextView
                if(position == 0) {
                    view.setTextColor(Color.GRAY)
                } else {
                    view.setTextColor(Color.BLACK)
                }
                return view
            }

        }

        val spinnerAdapterLifeCycleBouquet = object : ArrayAdapter<String>(requireContext(),android.R.layout.simple_spinner_item, itemsLifecycleBouquet) {

            override fun isEnabled(position: Int): Boolean {
                return position != 0
            }

            override fun getDropDownView(
                position: Int,
                convertView: View?,
                parent: ViewGroup
            ): View {
                val view: TextView = super.getDropDownView(position, convertView, parent) as TextView
                if(position == 0) {
                    view.setTextColor(Color.GRAY)
                } else {
                    view.setTextColor(Color.BLACK)
                }
                return view
            }

        }

        spinnerAdapterFlowers.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerFlowers1.adapter = spinnerAdapterFlowers
        binding.spinnerFlowers2.adapter = spinnerAdapterFlowers
        binding.spinnerFlowers3.adapter = spinnerAdapterFlowers
        binding.spinnerFlowers4.adapter = spinnerAdapterFlowers
        binding.spinnerFlowers5.adapter = spinnerAdapterFlowers

        spinnerAdapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerCategory.adapter = spinnerAdapterCategory

        spinnerAdapterLifeCycleBouquet.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerDate.adapter = spinnerAdapterLifeCycleBouquet


        binding.spinnerFlowers1.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val value = parent!!.getItemAtPosition(position).toString()
                if(value == itemsFlowers[0]){
                    (view as TextView).setTextColor(Color.GRAY)
                }
            }

        }

        binding.spinnerFlowers2.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val value = parent!!.getItemAtPosition(position).toString()
                if(value == itemsFlowers[0]){
                    (view as TextView).setTextColor(Color.GRAY)
                }
            }

        }

        binding.spinnerFlowers3.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val value = parent!!.getItemAtPosition(position).toString()
                if(value == itemsFlowers[0]){
                    (view as TextView).setTextColor(Color.GRAY)
                }
            }

        }

        binding.spinnerFlowers4.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val value = parent!!.getItemAtPosition(position).toString()
                if(value == itemsFlowers[0]){
                    (view as TextView).setTextColor(Color.GRAY)
                }
            }

        }

        binding.spinnerFlowers5.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val value = parent!!.getItemAtPosition(position).toString()
                if(value == itemsFlowers[0]){
                    (view as TextView).setTextColor(Color.GRAY)
                }
            }

        }

        binding.spinnerCategory.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val value = parent!!.getItemAtPosition(position).toString()
                if(value == itemsCategories[0]){
                    (view as TextView).setTextColor(Color.GRAY)
                }
            }

        }

        binding.spinnerDate.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val value = parent!!.getItemAtPosition(position).toString()
                if(value == itemsLifecycleBouquet[0]){
                    (view as TextView).setTextColor(Color.GRAY)
                }
            }

        }

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_constructorBouquetFragment_to_addBouquetFragment)
        }

        return view

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}