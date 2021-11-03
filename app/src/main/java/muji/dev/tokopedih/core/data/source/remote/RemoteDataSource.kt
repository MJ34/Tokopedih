package muji.dev.tokopedih.core.data.source.remote

import muji.dev.tokopedih.core.data.source.remote.network.ApiService
import muji.dev.tokopedih.core.data.source.remote.request.LoginRequest
import muji.dev.tokopedih.core.data.source.remote.request.RegisterRequest

class RemoteDataSource (private val api: ApiService) {

    suspend fun login(data: LoginRequest) = api.login(data)

    suspend fun register(data: RegisterRequest) = api.register(data)

}