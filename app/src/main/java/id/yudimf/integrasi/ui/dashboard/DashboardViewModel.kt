package id.yudimf.integrasi.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.yudimf.integrasi.model.response.ListWbpResponse
import id.yudimf.integrasi.repository.WbpRepository

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    private val wbpRepository = WbpRepository()

    fun getListWbp(nik : String) : MutableLiveData<ListWbpResponse>{
        return wbpRepository.getListWbp(nik)
    }

}