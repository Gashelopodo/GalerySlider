package com.gashe.galeryslider.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.gashe.galeryslider.Fragments.CategoryFragment;

/**
 * Created by Gashe on 27/3/17.
 */

public class CategoryPageAdapter extends FragmentStatePagerAdapter {

    private Context context;
    private String[] categories;

    public CategoryPageAdapter(FragmentManager fm, Context context, String[] categories) {
        super(fm);
        this.context = context;
        this.categories = categories;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        fragment = new CategoryFragment(position, categories);
        return fragment;
    }

    @Override
    public int getCount() {
        return categories.length;
    }
}
