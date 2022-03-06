package id.yudimf.integrasi.ui.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import id.yudimf.integrasi.databinding.ActivityRegistrationBinding
import id.yudimf.integrasi.model.Penjamin

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding

    private lateinit var viewModel: RegistrationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[RegistrationViewModel::class.java]
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        val btnRegistration = binding.btnRegistration

        btnRegistration.setOnClickListener {
            val nik = binding.registrationNik.text.toString()
            val password = binding.registrationPassword.text.toString()
            val passwordRetype = binding.registrationPasswordRetype.text.toString()
            val name = binding.registrationName.text.toString()
            val address = binding.registrationAddress.text.toString()
            val phoneNumber = binding.registrationPhoneNumber.text.toString()
            val age = binding.registrationAge.text.toString()
            val job = binding.registrationJob.text.toString()

            if (nik.isNotEmpty() &&
                password.isNotEmpty() &&
                passwordRetype.isNotEmpty() &&
                name.isNotEmpty() &&
                address.isNotEmpty() &&
                phoneNumber.isNotEmpty() &&
                age.isNotEmpty() &&
                job.isNotEmpty()){
                val data = Penjamin(nik,password,name,address,phoneNumber,age,job)
                Log.d("UserRegistration",data.toString())
                viewModel.registration(data).observe(this){
                    if (it != null){
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                        finish()
                    }
                    else{
                        Toast.makeText(this, "Registrasi Gagal", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else{
                Toast.makeText(this, "Harap Isi Semua Kolom", Toast.LENGTH_SHORT).show()
            }

        }

    }
}