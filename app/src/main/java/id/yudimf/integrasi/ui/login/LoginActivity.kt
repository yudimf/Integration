package id.yudimf.integrasi.ui.login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import id.yudimf.integrasi.HomeActivity
import id.yudimf.integrasi.databinding.ActivityLoginBinding
import id.yudimf.integrasi.ui.registration.RegistrationActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

    private lateinit var viewModel: LoginViewModel

    private lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initState()
    }

    private fun initState(){
        sharedPreferences = getSharedPreferences("UserPref", Context.MODE_PRIVATE)
        if (sharedPreferences.getString("nik","")!!.isNotEmpty()){
            val intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    override fun onStart() {
        super.onStart()
        binding.btnLogin.setOnClickListener {
            val nik = binding.loginNik.text.toString()
            val password = binding.loginPassword.text.toString()
            if (nik.isNotEmpty() && password.isNotEmpty()){
                viewModel.login(nik,password).observe(this) {
                    if (it != null) {
                        if (it.status == true) {
                            val intent = Intent(this, HomeActivity::class.java)
                            sharedPreferences.edit().putString("nik", it.penjamin?.nik).apply()
                            sharedPreferences.edit().putString("namaPenjamin", it.penjamin?.namaPenjamin).apply()
                            sharedPreferences.edit().putString("alamatPenjamin", it.penjamin?.alamatPenjamin).apply()
                            sharedPreferences.edit().putString("pekerjaanPenjamin", it.penjamin?.pekerjaanPenjamin).apply()
                            sharedPreferences.edit().putString("noTelpPenjamin", it.penjamin?.noTelpPenjamin).apply()
                            sharedPreferences.edit().putString("umurPenjamin", it.penjamin?.umurPenjamin).apply()
                            Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                            Log.d("UserResponse", it.toString())
                        }
                    }
                }
            }
            else{
                Toast.makeText(this,"NIK dan Password Tidak Boleh Kosong !",Toast.LENGTH_SHORT).show()
            }

        }

        binding.clickToRegister.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}