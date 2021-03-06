package weatherintamriel.module

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import weatherintamriel.api.ZipCodeApi
import javax.inject.Singleton

@Module
class ZipCodeApiModule {
    private val BASE_URL = "http://www.zipcodeapi.com/rest/"

    @Provides
    @Singleton
    fun provideZipCodeApi(): ZipCodeApi {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(OkHttpClient())
                .build()

        return retrofit.create(ZipCodeApi::class.java)
    }
}