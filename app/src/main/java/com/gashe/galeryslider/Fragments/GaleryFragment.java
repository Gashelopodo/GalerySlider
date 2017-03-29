package com.gashe.galeryslider.Fragments;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.gashe.galeryslider.Listeners.ButtonListener;
import com.gashe.galeryslider.R;

/**
 * Created by Gashe on 27/3/17.
 */

public class GaleryFragment extends Fragment {

    private Bitmap[] bitmaps;
    private int position;

    public GaleryFragment(int position, Bitmap[] bitmaps) {
        this.position = position;
        this.bitmaps = bitmaps;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View element = null;
        element = inflater.inflate(R.layout.galery_fragment, container, false);

        ImageView imageView = (ImageView)element.findViewById(R.id.imageGalery);
        imageView.setImageBitmap(bitmaps[position]);

        ImageButton buttonLike = (ImageButton)element.findViewById(R.id.buttonLike);
        ImageButton buttonNolike = (ImageButton)element.findViewById(R.id.buttonNolike);

        buttonLike.setOnClickListener(new ButtonListener(element.getContext()));
        buttonNolike.setOnClickListener(new ButtonListener(element.getContext()));


        return element;
    }
}
