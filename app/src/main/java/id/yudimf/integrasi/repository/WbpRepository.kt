package id.yudimf.integrasi.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.TypeAdapter
import id.yudimf.integrasi.model.response.DetailWbpResponse
import id.yudimf.integrasi.model.response.ListWbpResponse
import id.yudimf.integrasi.model.response.WbpResponse
import id.yudimf.integrasi.retrofit.ApiMain
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class WbpRepository {

    fun getListWbp(nik : String) : MutableLiveData<ListWbpResponse> {
        val listWbpResponse = MutableLiveData<ListWbpResponse>()

        ApiMain().services.getListWbp(nik).enqueue(object : Callback<ListWbpResponse>{
            override fun onResponse(call: Call<ListWbpResponse>, response: Response<ListWbpResponse>) {
                if (response.isSuccessful){
                    listWbpResponse.postValue(response.body())
                }
                else{
                    val gson = Gson()
                    val adapter: TypeAdapter<ListWbpResponse> =
                        gson.getAdapter(ListWbpResponse::class.java)
                    try {
                        if (response.errorBody() != null)
                            listWbpResponse.postValue(adapter.fromJson(response.errorBody()!!.string()))
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call<ListWbpResponse>, t: Throwable) {
                listWbpResponse.postValue(ListWbpResponse())
                Log.d("LoginResponse",t.stackTraceToString())
            }

        })

        return listWbpResponse
    }

    fun getDetailWbp(nik : String,
                     idwbp : String,
                     nip : String) : MutableLiveData<DetailWbpResponse> {
        val detailWbpResponse = MutableLiveData<DetailWbpResponse>()

        ApiMain().services.getDetailWbp(nik,idwbp, nip).enqueue(object : Callback<DetailWbpResponse>{
            override fun onResponse(
                call: Call<DetailWbpResponse>,
                response: Response<DetailWbpResponse>
            ) {
                if (response.isSuccessful){
                    detailWbpResponse.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<DetailWbpResponse>, t: Throwable) {
                detailWbpResponse.postValue(DetailWbpResponse())
                Log.d("LoginResponse",t.stackTraceToString())
            }


        })

        return detailWbpResponse
    }

    fun insertWbp(nik : RequestBody,
                  name : RequestBody,
                  perkara : RequestBody,
                  tahun : RequestBody,
                  bulan : RequestBody,
                  hubungan : RequestBody,
                  file : MultipartBody.Part?) : MutableLiveData<WbpResponse>{

        val wbpResponse = MutableLiveData<WbpResponse>()
        ApiMain().services.insertWbp(nik,name,perkara,tahun, bulan, hubungan, file).enqueue(object : Callback<WbpResponse>{
            override fun onResponse(call: Call<WbpResponse>, response: Response<WbpResponse>) {
                Log.d("wbpResponse",response.body()?.message.toString())
                if(response.isSuccessful){
                    wbpResponse.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<WbpResponse>, t: Throwable) {
                Log.d("wbpResponse",t.toString())
                wbpResponse.postValue(WbpResponse())
            }

        })
        return wbpResponse
    }

}