package muji.dev.tokopedih.ui.keranjang

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import muji.dev.tokopedih.databinding.FragmentKeranjangBinding


class KeranjangFragment : Fragment() {

    private lateinit var notificationsViewModel: KeranjangViewModel
    private var keranjangBinding: FragmentKeranjangBinding? = null

    private val binding get() = keranjangBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        notificationsViewModel = ViewModelProvider(this).get(KeranjangViewModel::class.java)
        keranjangBinding = FragmentKeranjangBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        keranjangBinding = null
    }

}