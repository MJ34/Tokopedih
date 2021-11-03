package muji.dev.tokopedih.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import muji.dev.tokopedih.core.data.repository.AppRepository
import muji.dev.tokopedih.core.data.source.remote.request.LoginRequest
import muji.dev.tokopedih.core.data.source.remote.request.RegisterRequest

class AuthViewModel(val repo: AppRepository) : ViewModel() {

    fun login(data: LoginRequest) = repo.login(data).asLiveData()

    fun register(data: RegisterRequest) = repo.register(data).asLiveData()
}