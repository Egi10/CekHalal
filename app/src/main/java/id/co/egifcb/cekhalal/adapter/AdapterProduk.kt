package id.co.egifcb.cekhalal.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.egifcb.cekhalal.R
import id.co.egifcb.cekhalal.model.Produk
import kotlinx.android.synthetic.main.layout_list.view.*

class AdapterProduk(private val context: Context, private val list: List<Produk>)
    : RecyclerView.Adapter<AdapterProduk.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
            AdapterProduk.ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_list, parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(produk: Produk) {
            val namaProduk = produk.namaProduk
            val nomorSertifikat = produk.nomorSertifikat
            val namaProdusen = produk.namaProdusen
            val berlakuHingga = produk.berlakuHingga

            itemView.tv_nama_produk.text = "$namaProduk"
            itemView.tv_nomor_sertifikat.text = "$nomorSertifikat"
            itemView.tv_nama_produsen.text = "$namaProdusen"
            itemView.tv_berlaku_hingga.text = "$berlakuHingga"
        }
    }
}