package id.yudimf.integrasi.model.response

import com.google.gson.annotations.SerializedName
import id.yudimf.integrasi.model.Penjamin

data class PenjaminResponse(

    @SerializedName("status")
    var status: Boolean? = null,

    @SerializedName("message")
    var message: String? = null,

    @SerializedName("data")
    var penjamin: Penjamin? = null

)
