package id.yudimf.integrasi.retrofit

import id.yudimf.integrasi.model.User
import id.yudimf.integrasi.model.response.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiServices {

    @GET("penjamin")
    fun getUsers(): Call<UserResponse>

    @GET("penjamin/login")
    fun login(@Query("nik") nik : String,
              @Query("password") password : String): Call<UserResponse>

    @Headers("Content-Type: application/json")
    @POST("penjamin/registration")
    fun registration(@Body data : User): Call<UserResponse>

}