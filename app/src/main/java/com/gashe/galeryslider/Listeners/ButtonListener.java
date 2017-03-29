package com.gashe.galeryslider.Listeners;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.gashe.galeryslider.Activities.GaleryActivity;
import com.gashe.galeryslider.R;

/**
 * Created by Gashe on 28/3/17.
 */

public class ButtonListener implements View.OnClickListener {

    private Context context;
    private int position;

    public ButtonListener(Context context) {
        this.context = context;
    }

    public ButtonListener(Context context, int position) {
        this.context = context;
        this.position = position;
    }

    @Override
    public void onClick(View view) {

        Activity activity = (Activity)context;
        ViewPager viewPager = null;
        int num = 0;
        boolean buttonLike = false;

        switch (view.getId()){
            case R.id.buttonCategory:
                Intent intent = new Intent(context, GaleryActivity.class);
                intent.putExtra("position", position);
                context.startActivity(intent);
                break;
            case R.id.buttonLike: buttonLike = true;
                break;
            case R.id.buttonNolike: buttonLike = true;
                break;
        }

        if(buttonLike){
            viewPager = (ViewPager)activity.findViewById(R.id.viewPagerGalery);
            num = viewPager.getAdapter().getCount();
            if((viewPager.getCurrentItem() + 1) < num) viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            else viewPager.setCurrentItem(0);
        }


    }


}
