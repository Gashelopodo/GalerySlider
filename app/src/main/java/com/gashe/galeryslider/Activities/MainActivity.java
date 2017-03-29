package com.gashe.galeryslider.Activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gashe.galeryslider.Adapters.CategoryPageAdapter;
import com.gashe.galeryslider.R;

public class MainActivity extends AppCompatActivity {

    private String[] categories = new String[]{
            "deportes",
            "peliculas",
            "famosos",
            "paisajes"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ViewPager viewPager = (ViewPager) findViewById(R.id.categoryViewPager);
        CategoryPageAdapter categoryPageAdapter = new CategoryPageAdapter(getSupportFragmentManager(), this, categories);
        viewPager.setAdapter(categoryPageAdapter);


    }
}
