package com.example.dsg.controller.venues.detail;

import android.Manifest;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dsg.R;
import com.example.dsg.controller.base.BaseFragment;
import com.example.dsg.controller.venues.VenuesCallback;
import com.example.dsg.controller.venues.VenuesListItemAdapter;
import com.example.dsg.controller.venues.VenuesListItemCallback;
import com.example.dsg.controller.venues.VenuesViewModel;
import com.example.dsg.databinding.FragmentVenueDetailBinding;
import com.example.dsg.databinding.FragmentVenuesListBinding;
import com.example.dsg.location.LocationHelper;
import com.example.dsg.model.DataManager;
import com.example.dsg.model.domain.VenueDisplaybleItem;
import com.example.dsg.model.domain.VenueMapper;
import com.example.dsg.model.web.WebManager;
import com.example.dsg.model.web.venue.Venues;
import com.example.dsg.permission.PermissionResultCallback;
import com.example.dsg.permission.PermissionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class VenuesDetailFragment extends BaseFragment implements VenueDetailCallback {

    public static final String TAG = VenuesDetailFragment.class.getSimpleName();

    private static final String ARG_VENUE = "ARG_VENUE";

    private FragmentVenueDetailBinding mBinding;
    private VenueDetailViewModel mViewModel;
    private VenueDisplaybleItem mVenueDisplaybleItem;


    public static VenuesDetailFragment newInstance(VenueDisplaybleItem venueDisplaybleItem) {
        Bundle args = new Bundle();
        args.putParcelable(ARG_VENUE, venueDisplaybleItem);

        VenuesDetailFragment fragment = new VenuesDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        component().inject(this);
        mVenueDisplaybleItem = getArguments().getParcelable(ARG_VENUE);
        mViewModel = new VenueDetailViewModel(this, mVenueDisplaybleItem);

    }

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_venue_detail, container, false);
        mBinding.setViewModel(mViewModel);
        return mBinding.getRoot();
    }

}
