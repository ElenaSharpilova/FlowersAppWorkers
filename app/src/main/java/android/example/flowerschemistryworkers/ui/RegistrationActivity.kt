package android.example.flowerschemistryworkers.ui

import android.content.Intent
import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.databinding.ActivityRegistrationBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod

class RegistrationActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    private var isShowPass = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Показывает вводимый пароль
        binding.ivShowHidePass.setOnClickListener {
            isShowPass = !isShowPass
            showPassword(isShowPass)
        }
        showPassword(isShowPass)

        val phoneNumber = "+996555555555"

        binding.btnNext.setOnClickListener {
            if (binding.edTextPhone.text.toString() == phoneNumber){
                val intent = Intent(this, CourierActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, FloristActivity::class.java)
                startActivity(intent)
            }

        }
    }

    private fun showPassword(isShow: Boolean){
        if(isShow){
            binding.edTextPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            binding.ivShowHidePass.setImageResource(R.drawable.ic_open_eye)
        } else {
            binding.edTextPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            binding.ivShowHidePass.setImageResource(R.drawable.ic_close_eye)
        }

        binding.edTextPassword.setSelection(binding.edTextPassword.text.toString().length)
    }
}