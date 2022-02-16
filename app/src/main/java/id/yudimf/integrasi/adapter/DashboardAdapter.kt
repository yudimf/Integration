package id.yudimf.integrasi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.yudimf.integrasi.R
import id.yudimf.integrasi.model.Inmate

class DashboardAdapter(private val list : List<Inmate>) :
    RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {

    private var onItemClickCallback : OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Inmate)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(inmate: Inmate){
            itemView.setOnClickListener {
                val imageView: ImageView = itemView.findViewById(R.id.item_image_view_wbp)
                val textView: TextView = itemView.findViewById(R.id.item_wbp_name)
                onItemClickCallback?.onItemClicked(inmate)
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