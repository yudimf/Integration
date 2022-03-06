package id.yudimf.integrasi.ui.wbp

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.yudimf.integrasi.R
import id.yudimf.integrasi.adapter.DashboardAdapter
import id.yudimf.integrasi.adapter.ProgresAdapter
import id.yudimf.integrasi.databinding.ActivityWbpDetailBinding
import id.yudimf.integrasi.model.Progres
import id.yudimf.integrasi.model.Wbp

class WbpDetailActivity : AppCompatActivity() {

    private var _binding: ActivityWbpDetailBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: WbpViewModel
    private lateinit var sharedPreferences : SharedPreferences
    private lateinit var wbpSelected : Wbp

    companion object {
        const val EXTRA_WBP = "extra_wbp"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityWbpDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[WbpViewModel::class.java]
        sharedPreferences = getSharedPreferences("UserPref", Context.MODE_PRIVATE)
        wbpSelected = intent.getParcelableExtra<Wbp>(EXTRA_WBP) as Wbp
        val listProgres = ArrayList<Progres>()
        val adapter = ProgresAdapter(listProgres)
        val recyclerView : RecyclerView = binding.recycleProgres
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val nik = sharedPreferences.getString("nik","").toString()
        val idWbp = wbpSelected.idWbp.toString()
        val nip = wbpSelected.nipPkBapas.toString()
        Log.d("NIPEY",nip)
        binding.detailWbpName.text = "it.wbp?.namaWbp"
        viewModel.detailWbp(nik,idWbp,nip).observe(this, Observer {
            if (it != null){
                if (it.status == true){
                    binding.detailWbpName.text = it.wbp?.namaWbp
                    binding.detailWbpPerkara.text = it.wbp?.perkara
                    binding.detailWbpPidana.text = it.wbp?.tahunPidana.toString()+" Tahun "+it.wbp?.bulanPidana.toString()+" Bulan"
                    binding.detailWbpPenjamin.text = it.penjamin?.namaPenjamin
                    binding.detailWbpHubungan.text = it.wbp?.hubungan
                    if (it.wbp?.statusValidasi != null){
                        if (it.wbp?.statusValidasi == 1){
                            binding.detailWbpStatusValidasi.text = "Sudah Divalidasi"
                        }
                        else{
                            binding.detailWbpStatusValidasi.text = "Ditolak"
                        }
                        binding.detailWbpTanggalValidasi.text = it.wbp?.tanggalValidasi
                    }
                    if(it.pkBapas != null){
                        binding.detailWbpPkBapas.text = it.pkBapas?.namaPkBapas
                        binding.detailWbpTelpPk.text = it.pkBapas?.noTelpPkBapas
                        binding.detailWbpBapas.text = it.pkBapas?.namaBapas
                    }

                    if (it.listProgres != null){
                        listProgres.addAll(it.listProgres!!)
                        adapter.notifyDataSetChanged()
                    }

                    Toast.makeText(applicationContext,it.message,Toast.LENGTH_SHORT).show()
                    Log.d("detailWbp",it.toString())
                }
            }
        })
    }

}