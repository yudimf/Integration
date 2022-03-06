package id.yudimf.integrasi.ui.wbp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import id.yudimf.integrasi.databinding.ActivityConditionBinding

class TermAndConditionActivity : AppCompatActivity() {

    private lateinit var binding : ActivityConditionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConditionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConditionNext.setOnClickListener {
            val intent = Intent(this, IntegrationFormActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.downloadFormulir.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://192.168.50.2/integration-rest/upload/formulir.pdf"))
            ContextCompat.startActivity(this, browserIntent, null)
        }

    }
}