package muji.dev.tokopedih.core.data.source.remote.response

import muji.dev.tokopedih.core.data.source.model.User

data class LoginResponse(
    val code: Int? = null,
    val message: String? = null,
    val data: User? = null
)
