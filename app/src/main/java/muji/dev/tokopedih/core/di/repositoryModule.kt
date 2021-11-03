package muji.dev.tokopedih.core.di

import muji.dev.tokopedih.core.data.repository.AppRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { AppRepository(get(), get()) }
}