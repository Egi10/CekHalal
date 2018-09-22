package id.co.egifcb.cekhalal.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import id.co.egifcb.cekhalal.R
import id.co.egifcb.cekhalal.adapter.AdapterProduk
import id.co.egifcb.cekhalal.api.APIConfig
import id.co.egifcb.cekhalal.model.Produk
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView, View.OnClickListener {
    private lateinit var mainPresenter: MainPresenter
    private lateinit var adapterProduk: AdapterProduk
    private var list: MutableList<Produk> = mutableListOf()
    private lateinit var llEmpty: LinearLayout
    private lateinit var tvMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        APIConfig.getConfig(this)
        mainPresenter = MainPresenter(this)

        llEmpty = findViewById(R.id.ll_empty)
        tvMessage = findViewById(R.id.tv_message)

        llEmpty.visibility = View.VISIBLE

        iv_search.setOnClickListener(this)

        swipeRefresh.setOnRefreshListener {
            swipeRefresh.isRefreshing = false
        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.iv_search -> {
                if (et_nama_produk.text.isEmpty()) {
                    Toast.makeText(this, "Oops, Isi Dulu Nama Produknya", Toast.LENGTH_SHORT).show()
                } else {
                    loadProduk(et_nama_produk.text.toString())
                }
            }
        }
    }

    private fun loadProduk(namaProduk: String?) {
        mainPresenter.getProduk(namaProduk)

        adapterProduk = AdapterProduk(this, list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapterProduk
    }

    override fun showLoading() {
        llEmpty.visibility = View.GONE
        et_nama_produk.isFocusableInTouchMode = true
        swipeRefresh.isRefreshing = true
    }

    override fun onResponse(listProduk: ArrayList<Produk>) {
        list.clear()
        listProduk.let {
            list.addAll(listProduk)
        }
        adapterProduk.notifyDataSetChanged()
    }

    override fun isEmpty() {
        llEmpty.visibility = View.VISIBLE
        tvMessage.text = getString(R.string.tidak_ada_data)
    }

    override fun onError(message: String?) {
        llEmpty.visibility = View.VISIBLE
        tvMessage.text = message
    }

    override fun hideLoading() {
        swipeRefresh.isRefreshing = false
    }
}
