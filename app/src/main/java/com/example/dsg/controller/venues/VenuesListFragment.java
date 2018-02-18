package com.example.dsg.controller.venues;

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
import com.example.dsg.controller.NavigationListener;
import com.example.dsg.controller.base.BaseFragment;
import com.example.dsg.databinding.FragmentVenuesListBinding;
import com.example.dsg.model.DataManager;
import com.example.dsg.model.domain.VenueDisplaybleItem;
import com.example.dsg.model.domain.VenueMapper;
import com.example.dsg.model.web.WebManager;
import com.example.dsg.model.web.venue.Venues;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class VenuesListFragment extends BaseFragment implements VenuesCallback, VenuesListItemCallback {

    public static final String TAG = VenuesListFragment.class.getSimpleName();

    @Inject protected WebManager mWebManager;
    @Inject protected DataManager mDataManager;

    private FragmentVenuesListBinding mBinding;
    private VenuesViewModel mViewModel;
    private RecyclerView mVenuesRecyclerView;
    private VenuesListItemAdapter mVenuesAdapter;
    private VenueMapper mVenueMapper;

    private List<VenueDisplaybleItem> mVenueDisplaybleItemList;

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        component().inject(this);
        mViewModel = new VenuesViewModel(this);
        mVenueMapper = new VenueMapper(mDataManager);
        mVenueDisplaybleItemList = new ArrayList<>();
    }


    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_venues_list, container, false);
        mBinding.setViewModel(mViewModel);
        setupUI();
        return mBinding.getRoot();
    }

    @Override public void onResume() {
        super.onResume();
        load();
    }

    private void setupUI() {
        mVenuesRecyclerView = mBinding.recyclerview;
        mVenuesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mVenuesAdapter = new VenuesListItemAdapter(this);
        mVenuesRecyclerView.setAdapter(mVenuesAdapter);
        mVenuesRecyclerView.setHasFixedSize(true);
    }

    private void load() {
        mWebManager.getVenues()
                .timeout(5, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::onLoadUsersSuccess, this::onLoadUsersError);

    }

    private void onLoadUsersError(Throwable throwable) {
        Log.d("DSG", "error");
    }

    private void onLoadUsersSuccess(Venues venues) {
        mVenueDisplaybleItemList = mVenueMapper.getVenueDisplaybleItemList(venues);
        mDataManager.setmVenueDisplaybleItemList(mVenueDisplaybleItemList);
        mVenuesAdapter.setVenueList(mVenueDisplaybleItemList);
        mVenuesAdapter.notifyDataSetChanged();
    }

    @Override public void onClickVenue(VenueDisplaybleItem venueDisplaybleItem) {
        ((NavigationListener) getActivity()).showDetailScreen(venueDisplaybleItem);
    }

    @Override public void onClickVenueFavorite(VenueDisplaybleItem venueDisplaybleItem, boolean isFavorite) {
        mDataManager.setVenueFavorite(venueDisplaybleItem, isFavorite);
        mVenuesAdapter.setVenueList(mDataManager.getmVenueDisplaybleItemList());
        mVenuesAdapter.notifyDataSetChanged();

    }
}
