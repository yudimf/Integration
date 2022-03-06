package id.yudimf.integrasi.retrofit

import id.yudimf.integrasi.model.Penjamin
import id.yudimf.integrasi.model.response.DetailWbpResponse
import id.yudimf.integrasi.model.response.ListWbpResponse
import id.yudimf.integrasi.model.response.PenjaminResponse
import id.yudimf.integrasi.model.response.WbpResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiServices {

    @GET("penjamin")
    fun getUsers(): Call<PenjaminResponse>

    @GET("penjamin/login")
    fun login(@Query("nik") nik : String,
              @Query("password") password : String): Call<PenjaminResponse>

    @Headers("Content-Type: application/json")
    @POST("penjamin/registration")
    fun registration(@Body data : Penjamin): Call<PenjaminResponse>

    @GET("wbp")
    fun getListWbp(@Query("nik") nik : String): Call<ListWbpResponse>

    @GET("wbp/detail")
    fun getDetailWbp(@Query("nik") nik : String,
                     @Query("idwbp") idwbp : String,
                     @Query("nip") nip : String) : Call<DetailWbpResponse>

    @Multipart
    @POST("wbp/insert")
    fun insertWbp(@Part("NIK") nik : RequestBody,
                  @Part("NAMA_WBP") name : RequestBody,
                  @Part("PERKARA") perkara : RequestBody,
                  @Part("TAHUN_PIDANA") tahun : RequestBody,
                  @Part("BULAN_PIDANA") bulan : RequestBody,
                  @Part("HUBUNGAN_DENGAN_PENJAMIN") hubungan : RequestBody,
                  @Part file : MultipartBody.Part?) : Call<WbpResponse>


}