package com.car2go.balvier.car2go.injections;

import com.car2go.balvier.car2go.viewmodel.CarListViewModel;
import com.car2go.balvier.car2go.viewmodel.CarViewModelFactory;

import dagger.Subcomponent;

/**
 * Created by Balvier on 9/23/2017.
 */

/**
 * A sub component to create ViewModels. It is called by the
 * {@link CarViewModelFactory}.
 */
@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    CarListViewModel projectListViewModel();
}
