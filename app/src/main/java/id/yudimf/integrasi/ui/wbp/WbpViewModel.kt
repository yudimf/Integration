package id.yudimf.integrasi.ui.wbp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import id.yudimf.integrasi.model.response.DetailWbpResponse
import id.yudimf.integrasi.model.response.WbpResponse
import id.yudimf.integrasi.repository.UserRepository
import id.yudimf.integrasi.repository.WbpRepository
import okhttp3.MultipartBody
import okhttp3.RequestBody

class WbpViewModel(application: Application) : AndroidViewModel(application) {

    private val wbpRepository = WbpRepository()

    fun insertWbp(nik : RequestBody,
                  name : RequestBody,
                  perkara : RequestBody,
                  tahun : RequestBody,
                  bulan : RequestBody,
                  hubungan : RequestBody,
                  file : MultipartBody.Part?) : MutableLiveData<WbpResponse> {
        return wbpRepository.insertWbp(nik, name, perkara, tahun, bulan, hubungan, file)
    }

    fun detailWbp(nik : String,idWbp : String, nip : String) : MutableLiveData<DetailWbpResponse>{
        return wbpRepository.getDetailWbp(nik,idWbp,nip)
    }

}