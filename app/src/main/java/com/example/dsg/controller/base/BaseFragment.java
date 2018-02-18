package com.example.dsg.controller.base;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.dsg.DsgApplication;
import com.example.dsg.inject.component.DsgComponent;
import com.trello.rxlifecycle.components.support.RxFragment;

import java.lang.reflect.Field;

import icepick.Icepick;

public abstract class BaseFragment extends RxFragment {

    private static final int DEFAULT_CHILD_ANIMATION_DURATION_MS = 250;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        component().inject(this);
        Icepick.restoreInstanceState(this, savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        final Fragment parentFragment = getParentFragment();
        if (!enter && parentFragment != null && parentFragment.isRemoving()) {
            Animation emptyAnimation = new AlphaAnimation(1, 1);
            emptyAnimation.setDuration(getNextAnimationDuration(parentFragment, DEFAULT_CHILD_ANIMATION_DURATION_MS));
            return emptyAnimation;
        } else {
            return super.onCreateAnimation(transit, enter, nextAnim);
        }
    }

    private static long getNextAnimationDuration(Fragment fragment, long defValue) {
        try {
            Field nextAnimField = Fragment.class.getDeclaredField("mNextAnim");
            nextAnimField.setAccessible(true);
            int nextAnimResource = nextAnimField.getInt(fragment);
            Animation nextAnim = AnimationUtils.loadAnimation(fragment.getActivity(), nextAnimResource);
            return (nextAnim == null) ? defValue : nextAnim.getDuration();
        } catch (NoSuchFieldException | IllegalAccessException | Resources.NotFoundException e) {
            return defValue;
        }
    }

    protected DsgComponent component() {
        return ((DsgApplication) getActivity().getApplication()).getDsgComponent();
    }

}
