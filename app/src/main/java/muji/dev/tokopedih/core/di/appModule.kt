package muji.dev.tokopedih.core.di

import muji.dev.tokopedih.core.data.source.local.LocalDataSource
import muji.dev.tokopedih.core.data.source.remote.RemoteDataSource
import muji.dev.tokopedih.core.data.source.remote.network.ApiConfig
import org.koin.dsl.module

val appModule = module {
    single { ApiConfig.provideApiService }

    single { RemoteDataSource(get()) }

    single { LocalDataSource() }
}