package id.co.egifcb.cekhalal.api

import com.google.gson.annotations.SerializedName
import id.co.egifcb.cekhalal.model.Produk

data class APIResponse (
        @SerializedName("status")
        val status: String? = null,

        @SerializedName("data")
        val data: ArrayList<Produk>)