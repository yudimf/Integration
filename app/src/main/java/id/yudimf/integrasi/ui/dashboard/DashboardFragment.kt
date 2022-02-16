package id.yudimf.integrasi.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import id.yudimf.integrasi.R
import id.yudimf.integrasi.adapter.DashboardAdapter
import id.yudimf.integrasi.databinding.FragmentDashboardBinding
import id.yudimf.integrasi.model.Inmate
import id.yudimf.integrasi.ui.inmate.ConditionActivity
import id.yudimf.integrasi.ui.inmate.InmateDetailActivity
import id.yudimf.integrasi.ui.login.LoginActivity

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val dashboardViewModel = ViewModelProvider(this)[DashboardViewModel::class.java]
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // getting the recyclerview by its id
        val recyclerView : RecyclerView = binding.recycleViewWbp
        recyclerView.layoutManager = LinearLayoutManager(context)
        val data = ArrayList<Inmate>()

        for (i in 1..20) {
            data.add(Inmate(R.drawable.ic_outline_person_24, "Warga Binaan $i"))
        }

        val adapter = DashboardAdapter(data)

        val fab : FloatingActionButton = binding.fab
        fab.setOnClickListener {
            val intent = Intent(context, ConditionActivity::class.java)
            startActivity(intent)
        }

        adapter.setOnItemClickCallback(object : DashboardAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Inmate) {
                val intent = Intent(context, InmateDetailActivity::class.java)
                startActivity(intent)
            }
        })

        recyclerView.adapter = adapter
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}