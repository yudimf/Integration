package id.yudimf.integrasi.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.yudimf.integrasi.R
import id.yudimf.integrasi.model.Wbp

class DashboardAdapter(private val list : List<Wbp>) :
    RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {

    private var onItemClickCallback : OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Wbp)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(wbp: Wbp){
            val textName: TextView = itemView.findViewById(R.id.item_wbp_name)
            val textPerkara: TextView = itemView.findViewById(R.id.item_wbp_perkara)
            val textPidana: TextView = itemView.findViewById(R.id.item_wbp_pidana)

            Log.d("NamaWbp", wbp.namaWbp.toString())

            textName.text = wbp.namaWbp
            textPerkara.text = "Perkara : "+wbp.perkara.toString()
            textPidana.text = "Pidana : "+wbp.tahunPidana.toString()+" Tahun "+wbp.bulanPidana.toString()+" Bulan"
            itemView.setOnClickListener {
                onItemClickCallback?.onItemClicked(wbp)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_wbp_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}