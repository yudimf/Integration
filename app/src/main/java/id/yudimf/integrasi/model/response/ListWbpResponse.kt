package id.yudimf.integrasi.model.response

import com.google.gson.annotations.SerializedName
import id.yudimf.integrasi.model.Wbp

data class ListWbpResponse(
    @SerializedName("status")
    var status: Boolean? = null,

    @SerializedName("message")
    var message: String? = null,

    @SerializedName("data")
    var listWbp : ArrayList<Wbp>? = null
)
