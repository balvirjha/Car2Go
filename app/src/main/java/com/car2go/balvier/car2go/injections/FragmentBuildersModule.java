package com.car2go.balvier.car2go.injections;

import com.car2go.balvier.car2go.view.userinterfaces.CarListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Balvier on 9/23/2017.
 */

@Module
public abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract CarListFragment contributeCarListFragment();
}
