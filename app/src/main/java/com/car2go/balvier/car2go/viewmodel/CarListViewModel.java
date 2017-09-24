package com.car2go.balvier.car2go.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.car2go.balvier.car2go.service.model.CarPojo;
import com.car2go.balvier.car2go.service.repository.CarRepository;

import javax.inject.Inject;

/**
 * Created by Balvier on 9/23/2017.
 */

public class CarListViewModel extends AndroidViewModel {
    private final LiveData<CarPojo> projectListObservable;

    @Inject
    public CarListViewModel(@NonNull CarRepository carRepository, @NonNull Application application) {
        super(application);

        // If any transformation is needed, this can be simply done by Transformations class ...
        projectListObservable = carRepository.getProjectList();
    }

    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */
    public LiveData<CarPojo> getProjectListObservable() {
        return projectListObservable;
    }
}
