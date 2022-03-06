package id.yudimf.integrasi.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.TypeAdapter
import id.yudimf.integrasi.model.Penjamin
import id.yudimf.integrasi.model.response.PenjaminResponse
import id.yudimf.integrasi.retrofit.ApiMain
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class UserRepository {

    fun login(nik : String, password : String) : MutableLiveData<PenjaminResponse>{
        val userResponse = MutableLiveData<PenjaminResponse>()

        ApiMain().services.login(nik, password).enqueue(object : Callback<PenjaminResponse>{
            override fun onResponse(call: Call<PenjaminResponse>, response: Response<PenjaminResponse>) {
                if (response.isSuccessful){
                    userResponse.postValue(response.body())
                }
                else{
                    errorResponse(userResponse, response)
                }
            }

            override fun onFailure(call: Call<PenjaminResponse>, t: Throwable) {
                userResponse.postValue(PenjaminResponse())
                Log.d("LoginResponse",t.stackTraceToString())
            }
        })
        return userResponse
    }

    fun registration(data : Penjamin) : MutableLiveData<PenjaminResponse>{
        val userResponse = MutableLiveData<PenjaminResponse>()

        Log.d("dataRegistration",data.toString())

        ApiMain().services.registration(data).enqueue(object : Callback<PenjaminResponse>{
            override fun onResponse(call: Call<PenjaminResponse>, response: Response<PenjaminResponse>) {
                if (response.isSuccessful){
                    userResponse.postValue(response.body())
                }
                else{
                    Log.d("RegistrationFail","Fail dah")
                    errorResponse(userResponse, response)
                }
            }

            override fun onFailure(call: Call<PenjaminResponse>, t: Throwable) {
                userResponse.postValue(PenjaminResponse())
                Log.d("RegistrationResponse",t.stackTraceToString())
            }
        })
        return userResponse
    }

    private fun errorResponse(penjaminResponse : MutableLiveData<PenjaminResponse>, response: Response<PenjaminResponse>){
        val gson = Gson()
        val adapter: TypeAdapter<PenjaminResponse> =
            gson.getAdapter(PenjaminResponse::class.java)
        try {
            if (response.errorBody() != null)
                penjaminResponse.postValue(adapter.fromJson(response.errorBody()!!.string()))
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

}