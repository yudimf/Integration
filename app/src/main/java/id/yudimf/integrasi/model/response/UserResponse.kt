package id.yudimf.integrasi.model.response

import com.google.gson.annotations.SerializedName
import id.yudimf.integrasi.model.User

data class UserResponse(

    @SerializedName("status")
    var status: Boolean? = null,

    @SerializedName("message")
    var message: String? = null,

    @SerializedName("data")
    var user: User? = null

)
