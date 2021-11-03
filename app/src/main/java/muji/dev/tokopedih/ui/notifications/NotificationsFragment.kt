package muji.dev.tokopedih.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.inyongtisto.myhelper.extension.pushActivity
import muji.dev.tokopedih.NavigationActivity
import muji.dev.tokopedih.R
import muji.dev.tokopedih.databinding.FragmentNotificationsBinding
import muji.dev.tokopedih.util.Prefs

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setUser()
        mainButton()
        return root
    }

    private fun mainButton() {
        binding.btnLogout.setOnClickListener {
            Prefs.isLogin = false
            pushActivity(NavigationActivity::class.java)
        }
    }

    private fun setUser() {
        val user = Prefs.getUser()
        if (user != null) {
            binding.apply {
                tvName.text = user.name
                tvEmail.text = user.email
                tvPhone.text = user.phone
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}