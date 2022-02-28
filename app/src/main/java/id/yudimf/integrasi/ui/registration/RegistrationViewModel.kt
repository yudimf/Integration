package id.yudimf.integrasi.ui.registration

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import id.yudimf.integrasi.model.User
import id.yudimf.integrasi.model.response.UserResponse
import id.yudimf.integrasi.repository.UserRepository

class RegistrationViewModel(application: Application) : AndroidViewModel(application) {

    private val userRepository = UserRepository()

    fun registration(data : User) : MutableLiveData<UserResponse>{
        return userRepository.registration(data)
    }

}