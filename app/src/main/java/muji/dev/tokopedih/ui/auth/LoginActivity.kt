package muji.dev.tokopedih.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.inyongtisto.myhelper.extension.*
import muji.dev.tokopedih.NavigationActivity
import muji.dev.tokopedih.core.data.source.remote.network.State
import muji.dev.tokopedih.core.data.source.remote.request.LoginRequest
import muji.dev.tokopedih.databinding.ActivityLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val viewModel: AuthViewModel by viewModel()

    private var loginBinding: ActivityLoginBinding? = null
    private val binding get() = loginBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
        mainButton()
    }

    private fun mainButton() {
        loginBinding!!.btnMasuk.setOnClickListener {
            login()
        }

        binding.btnDaftar.setOnClickListener {
            intentActivity(RegisterActivity::class.java)
        }
    }

    private fun setData() {

    }

    private fun login() {

        if (binding.edtEmail.isEmpty()) return
        if (binding.edtPassword.isEmpty()) return

        val body = LoginRequest(
            binding.edtEmail.text.toString(),
            binding.edtPassword.text.toString()
        )

        viewModel.login(body).observe(this, {

            when (it.state) {
                State.SUCCESS -> {
                    dismisLoading()
                    showToast("Selamat datang " + it.data?.name)
                    pushActivity(NavigationActivity::class.java)
                }
                State.ERROR -> {
                    dismisLoading()
                    toastError(it.message ?: "Error")
                }
                State.LOADING -> {
                    showLoading()
                }
            }
        })
    }

}