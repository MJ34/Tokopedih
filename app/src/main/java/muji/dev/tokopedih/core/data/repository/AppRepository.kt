package muji.dev.tokopedih.core.data.repository

import com.inyongtisto.myhelper.extension.getErrorBody
import com.inyongtisto.myhelper.extension.logs
import kotlinx.coroutines.flow.flow
import muji.dev.tokopedih.core.data.source.local.LocalDataSource
import muji.dev.tokopedih.core.data.source.remote.RemoteDataSource
import muji.dev.tokopedih.core.data.source.remote.network.Resource
import muji.dev.tokopedih.core.data.source.remote.request.LoginRequest
import muji.dev.tokopedih.core.data.source.remote.request.RegisterRequest
import muji.dev.tokopedih.util.Prefs

class AppRepository(val local: LocalDataSource, val remote: RemoteDataSource) {

    fun login(data: LoginRequest) = flow {
        emit(Resource.loading(null))
        try {
            remote.login(data).let {
                if (it.isSuccessful) {
                    Prefs.isLogin = true
                    val body = it.body()
                    val user = body?.data
                    Prefs.setUser(user)
                    emit(Resource.success(user))
                    logs("succes:" + body.toString())
                } else {
                    emit(Resource.error(it.getErrorBody()?.message ?: "Default error dongs", null))
                    logs("Error:" + "keteragan error")
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message ?: "Terjadi Kesalahan", null))
            logs("Error:" + e.message)
        }
    }

    fun register(data: RegisterRequest) = flow {
        emit(Resource.loading(null))
        try {
            remote.register(data).let {
                if (it.isSuccessful) {
                    Prefs.isLogin = true
                    val body = it.body()
                    val user = body?.data
                    Prefs.setUser(user)
                    emit(Resource.success(user))
                    logs("succes:" + body.toString())
                } else {
                    emit(Resource.error(it.getErrorBody()?.message ?: "Default error dongs", null))
                    logs("Error:" + "keteragan error")
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message ?: "Terjadi Kesalahan", null))
            logs("Error:" + e.message)
        }
    }

    class ErrorCustom(
        val ok: Boolean,
        val error_code: Int,
        val description: String? = null
    )
}