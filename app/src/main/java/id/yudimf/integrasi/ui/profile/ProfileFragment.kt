package id.yudimf.integrasi.ui.profile

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import id.yudimf.integrasi.HomeActivity
import id.yudimf.integrasi.databinding.FragmentProfileBinding
import id.yudimf.integrasi.ui.SplashScreenActivity
import id.yudimf.integrasi.ui.changepassword.ChangePasswordActivity
import id.yudimf.integrasi.ui.myprofile.MyProfileActivity

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    lateinit var sharedPreferences : SharedPreferences

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        sharedPreferences = requireActivity().getSharedPreferences("UserPref", Context.MODE_PRIVATE)

        val homeViewModel =
            ViewModelProvider(this)[ProfileViewModel::class.java]

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val myProfile: LinearLayout = binding.btnMyProfile
        myProfile.setOnClickListener {
            val intent = Intent(context, MyProfileActivity::class.java)
            startActivity(intent)
        }

        val changePassword : LinearLayout = binding.btnChangePassword
        changePassword.setOnClickListener {
            val intent = Intent(context, ChangePasswordActivity::class.java)
            startActivity(intent)
        }

        val logout = binding.btnLogout
        logout.setOnClickListener {
            sharedPreferences.edit().clear().apply()
            Toast.makeText(context,"Berhasil Logout",Toast.LENGTH_SHORT).show()
            val intent = Intent(context, SplashScreenActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}