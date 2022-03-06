package id.yudimf.integrasi.ui.wbp

import android.R.attr
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.yudimf.integrasi.databinding.ActivityIntegrationFormBinding
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody


class IntegrationFormActivity : AppCompatActivity() {

    private lateinit var binding : ActivityIntegrationFormBinding
    private lateinit var viewModel: WbpViewModel
    private lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntegrationFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[WbpViewModel::class.java]
        sharedPreferences = getSharedPreferences("UserPref", Context.MODE_PRIVATE)
        val nik = sharedPreferences.getString("nik","").toString()

        binding.btnSelect.setOnClickListener {
            val i = Intent(Intent.ACTION_GET_CONTENT)
            i.type = "application/pdf"
            startActivityForResult(i, 100)
        }

        binding.formBtnSave.setOnClickListener {
            val nama = binding.formNama.text.toString()
            val perkara = binding.formPerkara.text.toString()
            val tahunPidana = binding.formTahunPidana.text.toString()
            val bulanPidana = binding.formBulanPidana.text.toString()
            val hubungan    = binding.formHubungan.text.toString()

            val bodyNik = RequestBody.create("multipart/form-data".toMediaTypeOrNull(),nik)
            val bodyNama = RequestBody.create("multipart/form-data".toMediaTypeOrNull(),nama)
            val bodyPerkara = RequestBody.create("multipart/form-data".toMediaTypeOrNull(),perkara)
            val bodyTahunPidana = RequestBody.create("multipart/form-data".toMediaTypeOrNull(),tahunPidana)
            val bodyBulanPidana = RequestBody.create("multipart/form-data".toMediaTypeOrNull(),bulanPidana)
            val bodyHubungan = RequestBody.create("multipart/form-data".toMediaTypeOrNull(),hubungan)

            viewModel.insertWbp(bodyNik,bodyNama,bodyPerkara,bodyTahunPidana,bodyBulanPidana,bodyHubungan,null).observe(this, Observer {
                if (it != null){
                    if (it.status == true){
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                        finish()
                    }
                    else{
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(this, "Gagal Boyy", Toast.LENGTH_SHORT).show()
                }
            })

//            val intent = Intent(this, HomeActivity::class.java)
//            startActivity(intent)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode === 100 && resultCode === RESULT_OK && attr.data != null) {
            //the image URI
            binding.formFileName.text = "Formulir.pdf"
            //calling the upload file method after choosing the file
        }
    }
}