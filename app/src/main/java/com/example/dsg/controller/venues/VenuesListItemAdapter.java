package com.example.dsg.controller.venues;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dsg.BR;
import com.example.dsg.R;
import com.example.dsg.model.domain.VenueDisplaybleItem;
import com.example.dsg.viewholder.DsgViewHolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class VenuesListItemAdapter extends RecyclerView.Adapter<DsgViewHolder> {
    private VenuesListItemCallback mCallback;
    private List<VenueDisplaybleItem> mVenuesList = new ArrayList<>();

    public VenuesListItemAdapter(VenuesListItemCallback callback) {
        mCallback = callback;
    }

    @Override public DsgViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_venue, parent, false);
        return new DsgViewHolder(view);
    }

    @Override public void onBindViewHolder(DsgViewHolder holder, int position) {
        VenueDisplaybleItem venue = mVenuesList.get(position);
        VenuesListItemViewModel viewModel = new VenuesListItemViewModel(mCallback, venue);
        ViewDataBinding viewDataBinding = holder.getBinding();
        viewDataBinding.setVariable(BR.vm, viewModel);
        viewDataBinding.executePendingBindings();
    }

    @Override public int getItemCount() {
        return mVenuesList.size();
    }

    public void setVenueList(List<VenueDisplaybleItem> venueList) {
        mVenuesList = sortVenueList(venueList);
    }

    private List<VenueDisplaybleItem> sortVenueList(List<VenueDisplaybleItem> venueList) {
        Collections.sort(venueList, (venue1, venue2) -> {
            if (venue1.ismIsFavorite() != venue2.ismIsFavorite()) {
                return ((Boolean) venue2.ismIsFavorite()).compareTo(venue1.ismIsFavorite());
            } else {
                return Float.compare(venue1.getmDistanceFromCurrentLocation(), venue2.getmDistanceFromCurrentLocation());
            }
        });
        return venueList;
    }

}
