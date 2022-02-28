package id.yudimf.integrasi.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.TypeAdapter
import id.yudimf.integrasi.model.User
import id.yudimf.integrasi.model.response.UserResponse
import id.yudimf.integrasi.retrofit.ApiMain
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class UserRepository {

    fun login(nik : String, password : String) : MutableLiveData<UserResponse>{
        val userResponse = MutableLiveData<UserResponse>()

        ApiMain().services.login(nik, password).enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful){
                    userResponse.postValue(response.body())
                }
                else{
                    errorResponse(userResponse, response)
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                userResponse.postValue(UserResponse())
                Log.d("LoginResponse",t.stackTraceToString())
            }
        })
        return userResponse
    }

    fun registration(data : User) : MutableLiveData<UserResponse>{
        val userResponse = MutableLiveData<UserResponse>()

        Log.d("dataRegistration",data.toString())

        ApiMain().services.registration(data).enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful){
                    userResponse.postValue(response.body())
                }
                else{
                    Log.d("RegistrationFail","Fail dah")
                    errorResponse(userResponse, response)
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                userResponse.postValue(UserResponse())
                Log.d("RegistrationResponse",t.stackTraceToString())
            }
        })
        return userResponse
    }

    private fun errorResponse(userResponse : MutableLiveData<UserResponse>, response: Response<UserResponse>){
        val gson = Gson()
        val adapter: TypeAdapter<UserResponse> =
            gson.getAdapter(UserResponse::class.java)
        try {
            if (response.errorBody() != null)
                userResponse.postValue(adapter.fromJson(response.errorBody()!!.string()))
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

}