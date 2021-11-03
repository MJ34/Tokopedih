package muji.dev.tokopedih.core.data.source.remote.network

import muji.dev.tokopedih.core.data.source.remote.request.LoginRequest
import muji.dev.tokopedih.core.data.source.remote.request.RegisterRequest
import muji.dev.tokopedih.core.data.source.remote.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    suspend fun login(
        @Body login: LoginRequest,
    ): Response<LoginResponse>

    // "https://127.0.0.1:8000/api/register"
    @POST("register")
    suspend fun register(
        @Body data: RegisterRequest
    ): Response<LoginResponse>
}