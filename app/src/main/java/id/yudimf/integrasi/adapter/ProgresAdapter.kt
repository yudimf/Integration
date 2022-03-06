package id.yudimf.integrasi.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import id.yudimf.integrasi.R
import id.yudimf.integrasi.model.Progres
import id.yudimf.integrasi.model.Wbp

class ProgresAdapter(private val list : List<Progres>) :
    RecyclerView.Adapter<ProgresAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(progres: Progres){
            val status: TextView = itemView.findViewById(R.id.item_progres_status)
            val tanggal: TextView = itemView.findViewById(R.id.item_progres_tanggal)
            val keterangan: TextView = itemView.findViewById(R.id.item_progres_keterangan)
            val layoutSk : LinearLayout = itemView.findViewById(R.id.layout_detail_sk)
            val fileSk : TextView = itemView.findViewById(R.id.item_progres_filesk)

            status.text = progres.statusProgres
            tanggal.text = progres.progresCreatedAt
            keterangan.text = progres.keteranganProgres
            if (progres.fileSk == null){
                layoutSk.visibility = View.GONE
            }
            else{
                fileSk.setOnClickListener {
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://192.168.50.2/integration-rest/upload/SK_PB.pdf"))
                    startActivity(itemView.context,browserIntent,null)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_progres, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}