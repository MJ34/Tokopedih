package muji.dev.tokopedih.util


import com.chibatching.kotpref.KotprefModel
import com.inyongtisto.myhelper.extension.toJson
import com.inyongtisto.myhelper.extension.toModel
import muji.dev.tokopedih.core.data.source.model.User

object Prefs: KotprefModel() {

    var isLogin by booleanPref(false)
    var user by stringPref()

    fun setUser(data: User?) {
        user = data.toJson()
    }

    fun getUser(): User? {
        if (user.isEmpty()) return null
        return user.toModel(User::class.java)
    }
}