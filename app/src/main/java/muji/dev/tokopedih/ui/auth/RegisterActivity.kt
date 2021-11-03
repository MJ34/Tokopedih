package muji.dev.tokopedih.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.inyongtisto.myhelper.extension.*
import muji.dev.tokopedih.NavigationActivity
import muji.dev.tokopedih.core.data.source.remote.network.State
import muji.dev.tokopedih.core.data.source.remote.request.RegisterRequest
import muji.dev.tokopedih.databinding.ActivityRegisterBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : AppCompatActivity() {

    private val viewModel: AuthViewModel by viewModel()

    private var registerBinding: ActivityRegisterBinding? = null
    private val regisBinding get() = registerBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(regisBinding.root)

        setData()
    }

    private fun setData() {
        regisBinding.btnDaftar.setOnClickListener {
            register()
        }
    }

    private fun register() {
        if (regisBinding.edtName.isEmpty()) return
        if (regisBinding.edtPassword.isEmpty()) return
        if (regisBinding.edtEmail.isEmpty()) return
        if (regisBinding.edtPassword.isEmpty()) return

        val body = RegisterRequest(
            regisBinding.edtName.text.toString(),
            regisBinding.edtEmail.text.toString(),
            regisBinding.edtPhone.text.toString(),
            regisBinding.edtPassword.text.toString()
        )

        viewModel.register(body).observe(this, {

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