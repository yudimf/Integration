package id.yudimf.integrasi.model.response

import com.google.gson.annotations.SerializedName
import id.yudimf.integrasi.model.Penjamin
import id.yudimf.integrasi.model.PkBapas
import id.yudimf.integrasi.model.Progres
import id.yudimf.integrasi.model.Wbp

data class DetailWbpResponse(

    @SerializedName("status")
    var status: Boolean? = null,

    @SerializedName("message")
    var message: String? = null,

    @SerializedName("wbp")
    var wbp: Wbp? = null,

    @SerializedName("penjamin")
    var penjamin: Penjamin? = null,

    @SerializedName("pkbapas")
    var pkBapas: PkBapas? = null,

    @SerializedName("progres")
    var listProgres: ArrayList<Progres>? = null
)
