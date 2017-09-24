package com.car2go.balvier.car2go.view.userinterfaces;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.car2go.balvier.car2go.R;
import com.car2go.balvier.car2go.injections.Injectable;
import com.car2go.balvier.car2go.service.model.CarPojo;
import com.car2go.balvier.car2go.view.adapter.CarAdapter;
import com.car2go.balvier.car2go.viewmodel.CarListViewModel;

import javax.inject.Inject;

/**
 * Created by Balvier on 9/23/2017.
 */

public class CarListFragment extends LifecycleFragment implements Injectable {
    public static final String TAG = "CarListFragment";
    View mRoot;
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    CarAdapter carAdapter;
    RecyclerView recyclerView;
    TextView loading_cars;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.fragment_car_list, container, false);

        return mRoot;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = (RecyclerView) mRoot.findViewById(R.id.project_list);
        loading_cars = (TextView) mRoot.findViewById(R.id.loading_cars);
        loading_cars.setVisibility(View.VISIBLE);
        carAdapter = new CarAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(carAdapter);
        final CarListViewModel viewModel = ViewModelProviders.of(this,
                viewModelFactory).get(CarListViewModel.class);

        observeViewModel(viewModel);
    }

    private void observeViewModel(CarListViewModel viewModel) {
        viewModel.getProjectListObservable().observe(this, new Observer<CarPojo>() {
            @Override
            public void onChanged(@Nullable CarPojo projects) {
                if (projects != null) {
                    loading_cars.setVisibility(View.GONE);
                    carAdapter.setCarList(projects.getPlacemarks());
                }
            }
        });
    }

}
