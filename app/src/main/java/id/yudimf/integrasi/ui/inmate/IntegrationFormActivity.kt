package id.yudimf.integrasi.ui.inmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.yudimf.integrasi.HomeActivity
import id.yudimf.integrasi.databinding.ActivityIntegrationFormBinding

class IntegrationFormActivity : AppCompatActivity() {

    private lateinit var binding : ActivityIntegrationFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntegrationFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.formBtnSave.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }
}