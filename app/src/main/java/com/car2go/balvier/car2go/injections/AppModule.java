package com.car2go.balvier.car2go.injections;

import android.arch.lifecycle.ViewModelProvider;

import com.car2go.balvier.car2go.service.repository.CarRestService;
import com.car2go.balvier.car2go.viewmodel.CarViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Balvier on 9/23/2017.
 */

@Module(subcomponents = ViewModelSubComponent.class)
class AppModule {
    @Singleton
    @Provides
    CarRestService provideCarRestService() {
        return new Retrofit.Builder()
                .baseUrl(CarRestService.HTTPS_API_CAR2GO_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CarRestService.class);
    }

    @Singleton
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(
            ViewModelSubComponent.Builder viewModelSubComponent) {

        return new CarViewModelFactory(viewModelSubComponent.build());
    }
}
