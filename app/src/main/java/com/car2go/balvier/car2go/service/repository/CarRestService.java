package com.car2go.balvier.car2go.service.repository;

import com.car2go.balvier.car2go.service.model.CarPojo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Balvier on 9/23/2017.
 */

public interface CarRestService {
    String HTTPS_API_CAR2GO_URL = "http://redirect.mytaxi.net/car2go/";

    @GET("vehicles.json")
    Call<CarPojo> getListRepos();
}
