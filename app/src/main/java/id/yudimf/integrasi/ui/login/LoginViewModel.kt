package id.yudimf.integrasi.ui.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import id.yudimf.integrasi.model.response.PenjaminResponse
import id.yudimf.integrasi.repository.UserRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val userRepository = UserRepository()

    fun login(nik : String, password : String) : MutableLiveData<PenjaminResponse>{
        return userRepository.login(nik, password)
    }

}