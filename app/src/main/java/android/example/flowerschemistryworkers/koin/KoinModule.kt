package android.example.flowerschemistryworkers.koin

import android.example.flowerschemistryworkers.Constants
import android.example.flowerschemistryworkers.api.InterfaceAPI
import android.example.flowerschemistryworkers.repository.Repository
import android.example.flowerschemistryworkers.viewmodel.AllOrdersViewModel
import android.example.flowerschemistryworkers.viewmodel.UsersViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val retrofitModule = module {

    single { getOkHttp() }
    single { getRetrofitInstance(okHttpClient = get()) }
    single { getProductApi(retrofit = get()) }
    factory { Repository(serviceAPI = get()) }
}

val viewModules = module {
    viewModel { AllOrdersViewModel(repository = get()) }
    viewModel { UsersViewModel(repository = get()) }
}

fun getOkHttp(): OkHttpClient {
    return OkHttpClient.Builder()
        .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .build()
}

fun getProductApi(retrofit: Retrofit): InterfaceAPI {
    return retrofit.create(InterfaceAPI::class.java)
}

fun getRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}