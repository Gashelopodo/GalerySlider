package com.gashe.galeryslider.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gashe.galeryslider.Listeners.ButtonListener;
import com.gashe.galeryslider.R;

/**
 * Created by Gashe on 27/3/17.
 */

public class CategoryFragment extends Fragment {

    private int position;
    private String[] categories;

    public CategoryFragment(int position, String[] categories) {
        this.position = position;
        this.categories = categories;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View element = null;
        int resId = 0;

        element = inflater.inflate(R.layout.category_fragment, container, false);
        TextView title = (TextView) element.findViewById(R.id.titleCategory);
        title.setText(categories[position].toUpperCase());
        ImageView imageView = (ImageView) element.findViewById(R.id.imageCategory);

        resId = getResources().getIdentifier(categories[position], "drawable", "com.gashe.galeryslider");
        imageView.setImageResource(resId);

        Button button = (Button)element.findViewById(R.id.buttonCategory);
        button.setOnClickListener(new ButtonListener(getContext(), position));

        return element;


    }
}
