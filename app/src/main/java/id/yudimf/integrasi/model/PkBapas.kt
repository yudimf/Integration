package id.yudimf.integrasi.model

import com.google.gson.annotations.SerializedName

data class PkBapas(

    @SerializedName("NIP_PK_BAPAS")
    var nipPkBapas: String? = null,

    @SerializedName("ID_BAPAS")
    var idBapas: Int? = null,

    @SerializedName("NAMA_PK_BAPAS")
    var namaPkBapas: String? = null,

    @SerializedName("NO_TELP_PK_BAPAS")
    var noTelpPkBapas: String? = null,

    @SerializedName("NAMA_BAPAS")
    var namaBapas: String? = null,

    @SerializedName("ALAMAT_BAPAS")
    var alamatBapas: String? = null

)
