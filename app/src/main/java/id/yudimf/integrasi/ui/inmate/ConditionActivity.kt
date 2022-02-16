package id.yudimf.integrasi.ui.inmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.yudimf.integrasi.databinding.ActivityConditionBinding

class ConditionActivity : AppCompatActivity() {

    private lateinit var binding : ActivityConditionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConditionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConditionNext.setOnClickListener {
            val intent = Intent(this, IntegrationFormActivity::class.java)
            startActivity(intent)
        }

    }
}