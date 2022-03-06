package id.yudimf.integrasi.ui.dashboard

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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
import id.yudimf.integrasi.adapter.DashboardAdapter
import id.yudimf.integrasi.databinding.FragmentDashboardBinding
import id.yudimf.integrasi.model.Wbp
import id.yudimf.integrasi.ui.wbp.TermAndConditionActivity
import id.yudimf.integrasi.ui.wbp.WbpDetailActivity

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: DashboardViewModel
    private lateinit var sharedPreferences : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[DashboardViewModel::class.java]
        sharedPreferences = requireActivity().getSharedPreferences("UserPref", Context.MODE_PRIVATE)
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val nik = sharedPreferences.getString("nik","").toString()
        val listWbp = ArrayList<Wbp>()
        val adapter = DashboardAdapter(listWbp)

        viewModel.getListWbp(nik).observe(requireActivity()){
            if (it != null){
                if (it.status == true){
                    val data = it.listWbp
                    if (data != null){
                        listWbp.addAll(data)
                        binding.recycleViewWbp.visibility = View.VISIBLE
                        binding.notifKosongDashboard.visibility = View.GONE
                    }
                    else{
                        binding.recycleViewWbp.visibility = View.GONE
                        binding.notifKosongDashboard.visibility = View.VISIBLE
                    }
                    adapter.notifyDataSetChanged()
                }
                Log.d("ListWbp",it.toString())
            }
            else{
                Log.d("ListWbp","null")
            }
        }

        // getting the recyclerview by its id
        val recyclerView : RecyclerView = binding.recycleViewWbp
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter.setOnItemClickCallback(object : DashboardAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Wbp) {
                val intent = Intent(context, WbpDetailActivity::class.java)
                intent.putExtra(WbpDetailActivity.EXTRA_WBP,data)
                startActivity(intent)
            }
        })
        recyclerView.adapter = adapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fab : FloatingActionButton = binding.fab
        fab.setOnClickListener {
            val intent = Intent(context, TermAndConditionActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}