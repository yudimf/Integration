package id.yudimf.integrasi.ui.registration

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import id.yudimf.integrasi.model.Penjamin
import id.yudimf.integrasi.model.response.PenjaminResponse
import id.yudimf.integrasi.repository.UserRepository

class RegistrationViewModel(application: Application) : AndroidViewModel(application) {

    private val userRepository = UserRepository()

    fun registration(data : Penjamin) : MutableLiveData<PenjaminResponse>{
        return userRepository.registration(data)
    }

}