package id.yudimf.integrasi.ui.myprofile

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import id.yudimf.integrasi.R
import id.yudimf.integrasi.databinding.ActivityLoginBinding
import id.yudimf.integrasi.databinding.ActivityMyProfileBinding

class MyProfileActivity : AppCompatActivity() {

    private lateinit var sharedPreferences : SharedPreferences

    private lateinit var binding : ActivityMyProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyProfileBinding.inflate(layoutInflater)
        sharedPreferences = getSharedPreferences("UserPref", Context.MODE_PRIVATE)
        val nik = sharedPreferences.getString("nik","")
        val namaPenjamin = sharedPreferences.getString("namaPenjamin","")
        val alamatPenjamin = sharedPreferences.getString("alamatPenjamin","")
        val pekerjaanPenjamin = sharedPreferences.getString("pekerjaanPenjamin","")
        val noTelpPenjamin = sharedPreferences.getString("noTelpPenjamin","")
        val umurPenjamin = sharedPreferences.getString("umurPenjamin","")

        Log.d("sharedPreferences",namaPenjamin.toString())

        binding.myProfileNik.setText(nik)
        binding.myProfileName.setText(namaPenjamin)
        binding.myProfileAddress.setText(alamatPenjamin)
        binding.myProfileWork.setText(pekerjaanPenjamin)
        binding.myProfileNumber.setText(noTelpPenjamin)
        binding.myProfileAge.setText(umurPenjamin)

        setContentView(binding.root)
    }
}