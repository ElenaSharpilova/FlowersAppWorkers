package android.example.flowerschemistryworkers.ui

import android.content.Intent
import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.databinding.ActivityRegistrationBinding
import android.example.flowerschemistryworkers.viewmodel.UsersViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import com.auth0.android.jwt.Claim
import com.auth0.android.jwt.JWT
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class RegistrationActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    private var isShowPass = false
    private val userViewModel by viewModel<UsersViewModel>()
    lateinit var str: String

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
            getToken(binding.edTextPhone.text.toString(), binding.edTextPassword.text.toString())
        }


       //val phoneNumber = "+996555555555"
        /*binding.btnNext.setOnClickListener {
            if (binding.edTextPhone.text.toString() == phoneNumber){
                val intent = Intent(this, CourierActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, FloristActivity::class.java)
                startActivity(intent)
            }

        }*/
    }

    private fun getToken(number: String, password: String) {
        userViewModel.getToken(number, password)
        userViewModel.tokens.observe(this){
            val token: String = it.token
            val jwt = JWT(token)
            val claim: Claim = jwt.getClaim("role")
            when (claim.asString().toString()) {
                "Курьер" -> {
                    val intent = Intent(this, CourierActivity::class.java)
                    startActivity(intent)
                }
                "Флорист" -> {
                    val intent = Intent(this, FloristActivity::class.java)
                    startActivity(intent)
                }
            }
        }
        userViewModel.errorMessage.observe(this){
            Toast.makeText(this, "Неверный пароль", Toast.LENGTH_SHORT).show()
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