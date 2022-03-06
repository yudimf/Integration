package id.yudimf.integrasi.model

import com.google.gson.annotations.SerializedName

data class Penjamin(

    @SerializedName("NIK")
    var nik: String? = null,

    @SerializedName("PENJAMIN_PASSWORD")
    var penjaminPassword: String? = null,

    @SerializedName("NAMA_PENJAMIN")
    var namaPenjamin: String? = null,

    @SerializedName("ALAMAT_PENJAMIN")
    var alamatPenjamin: String? = null,

    @SerializedName("NO_TELP_PENJAMIN")
    var noTelpPenjamin: String? = null,

    @SerializedName("UMUR_PENJAMIN")
    var umurPenjamin: String? = null,

    @SerializedName("PEKERJAAN_PENJAMIN")
    var pekerjaanPenjamin: String? = null,

    @SerializedName("PENJAMIN_CREATED_AT")
    var penjaminCreatedAt: String? = null
)
