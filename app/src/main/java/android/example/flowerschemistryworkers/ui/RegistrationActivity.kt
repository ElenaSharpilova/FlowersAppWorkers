package android.example.flowerschemistryworkers.ui

import android.content.Intent
import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.databinding.ActivityMainBinding
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

        binding.btnNext.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
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