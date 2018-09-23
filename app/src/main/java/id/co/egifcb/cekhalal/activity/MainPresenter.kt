package id.co.egifcb.cekhalal.activity

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import id.co.egifcb.cekhalal.api.APIResponse

class MainPresenter(private val mainView: MainView) {
    fun getProduk(namaProduk: String?) {
        mainView.showLoading()

        AndroidNetworking.get("http://api.agusadiyanto.net/halal/?menu=nama_produk&query={nama_produk}")
                .addPathParameter("nama_produk", namaProduk)
                .setTag("produk")
                .setPriority(Priority.LOW)
                .build()
                .getAsObject(APIResponse::class.java, object : ParsedRequestListener<APIResponse> {
                    override fun onResponse(response: APIResponse?) {
                        response?.let {
                            if (response.status.equals("success")) {
                                mainView.onResponse(response.data)
                            } else {
                                mainView.isEmpty()
                            }
                        }
                        mainView.hideLoading()
                    }

                    override fun onError(anError: ANError?) {
                        mainView.onError(anError?.message.toString())
                        mainView.hideLoading()
                    }

                })
    }
}