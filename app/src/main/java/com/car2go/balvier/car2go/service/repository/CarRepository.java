package com.car2go.balvier.car2go.service.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.car2go.balvier.car2go.service.model.CarPojo;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Balvier on 9/23/2017.
 */

@Singleton
public class CarRepository {
    private CarRestService carRestService;

    @Inject
    public CarRepository(CarRestService carRestService) {
        this.carRestService = carRestService;
    }

    public LiveData<CarPojo> getProjectList() {
        final MutableLiveData<CarPojo> data = new MutableLiveData<>();

        carRestService.getListRepos().enqueue(new Callback<CarPojo>() {
            @Override
            public void onResponse(Call<CarPojo> call, Response<CarPojo> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CarPojo> call, Throwable t) {
                // TODO better error handling in part #2 ...
                data.setValue(null);
            }
        });

        return data;
    }

}
