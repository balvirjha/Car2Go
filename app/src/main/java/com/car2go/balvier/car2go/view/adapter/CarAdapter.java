package com.car2go.balvier.car2go.view.adapter;

import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.car2go.balvier.car2go.R;
import com.car2go.balvier.car2go.service.model.Placemark;

import java.util.List;
import java.util.Objects;

/**
 * Created by Balvier on 9/23/2017.
 */

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {

    List<? extends Placemark> carList;

    public CarAdapter() {
    }

    public void setCarList(final List<? extends Placemark> carList) {
        if (this.carList == null) {
            this.carList = carList;
            notifyItemRangeInserted(0, carList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return CarAdapter.this.carList.size();
                }

                @Override
                public int getNewListSize() {
                    return carList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return CarAdapter.this.carList.get(oldItemPosition).getVin() ==
                            carList.get(newItemPosition).getVin();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    Placemark placemark = carList.get(newItemPosition);
                    Placemark old = carList.get(oldItemPosition);
                    return placemark.getVin() == old.getVin()
                            && Objects.equals(placemark.getVin(), old.getVin());
                }
            });
            this.carList = carList;
            result.dispatchUpdatesTo(this);
        }
    }

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.car_list_item, parent, false);

        return new CarViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CarViewHolder holder, int position) {
        Placemark placemark = carList.get(position);
        holder.name.setText(placemark.getName());
        holder.address.setText(placemark.getAddress());
        holder.engineType.setText(placemark.getEngineType());
    }

    @Override
    public int getItemCount() {
        return carList == null ? 0 : carList.size();
    }

    static class CarViewHolder extends RecyclerView.ViewHolder {
        public TextView name, address, engineType;

        public CarViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            address = (TextView) view.findViewById(R.id.address);
            engineType = (TextView) view.findViewById(R.id.engineType);
        }
    }
}
