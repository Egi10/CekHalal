package id.co.egifcb.cekhalal.activity

import id.co.egifcb.cekhalal.model.Produk

interface MainView {
    fun showLoading()
    fun onResponse(listProduk: ArrayList<Produk>)
    fun isEmpty()
    fun onError(message: String?)
    fun hideLoading()
}