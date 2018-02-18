package com.example.dsg.viewholder;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class DsgViewHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding mViewDataBinding;

    public DsgViewHolder(View rowView) {
        super(rowView);
        mViewDataBinding = DataBindingUtil.bind(rowView);
    }

    public ViewDataBinding getBinding() {
        return mViewDataBinding;
    }

}
