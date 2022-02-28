package id.yudimf.integrasi.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Wbp(

    @SerializedName("ID_WBP")
    var idWbp: String? = null,

    @SerializedName("NIP_PK_BAPAS  ")
    var nipPkBapas: String? = null,

    @SerializedName("NIK")
    var nik: String? = null,

    @SerializedName("NAMA_WBP")
    var namaWbp: String? = null,

    @SerializedName("PERKARA")
    var perkara: String? = null,

    @SerializedName("TAHUN_PIDANA")
    var tahunPidana: Int? = null,

    @SerializedName("BULAN_PIDANA")
    var bulanPidana: Int? = null,

    @SerializedName("HUBUNGAN_DENGAN_PENJAMIN")
    var hubungan: String? = null,

    @SerializedName("STATUS_VALIDASI_WBP")
    var statusValidasi: String? = null,

    @SerializedName("TANGGAL_VALIDASI")
    var tanggalValidasi: Date? = null,

    @SerializedName("JENIS_USULAN")
    var jenisUsulan: String? = null,

    @SerializedName("FILE_FORMULIR")
    var fileForm: String? = null,

    @SerializedName("WBP_CREATED_AT")
    var wbpCreatedAt: Date? = null

)
