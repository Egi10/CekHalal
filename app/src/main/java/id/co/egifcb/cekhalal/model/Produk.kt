package id.co.egifcb.cekhalal.model

import com.google.gson.annotations.SerializedName

data class Produk (
        @SerializedName("nama_produk")
        val namaProduk: String? = null,

        @SerializedName("nomor_sertifikat")
        val nomorSertifikat: String? = null,

        @SerializedName("nama_produsen")
        val namaProdusen: String? = null,

        @SerializedName("berlaku_hingga")
        val berlakuHingga: String? = null)