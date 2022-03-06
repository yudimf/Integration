package id.yudimf.integrasi.model

import com.google.gson.annotations.SerializedName

data class Progres(

    @SerializedName("ID_PROGRES")
    var idProgres: Int? = null,

    @SerializedName("STATUS_PROGRES")
    var statusProgres: String? = null,

    @SerializedName("KETERANGAN_PROGRES")
    var keteranganProgres: String? = null,

    @SerializedName("FILE_SK")
    var fileSk: String? = null,

    @SerializedName("PROGRES_CREATED_AT")
    var progresCreatedAt: String? = null,

    @SerializedName("ID_WBP_PROGRES")
    var idWbp: Int? = null,

)
