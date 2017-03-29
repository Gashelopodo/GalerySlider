package com.gashe.galeryslider.Adapters;

import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.gashe.galeryslider.Fragments.GaleryFragment;


/**
 * Created by Gashe on 27/3/17.
 */

public class GaleryPageAdapter extends FragmentStatePagerAdapter {

    private Bitmap[] bitmaps;

    public GaleryPageAdapter(FragmentManager fm, Bitmap[] bitmaps) {
        super(fm);
        this.bitmaps = bitmaps;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        fragment = new GaleryFragment(position, bitmaps);
        return fragment;
    }

    @Override
    public int getCount() {
        return bitmaps.length;
    }
}
