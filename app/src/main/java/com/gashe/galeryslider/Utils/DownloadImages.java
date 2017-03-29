package com.gashe.galeryslider.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.gashe.galeryslider.Activities.GaleryActivity;
import com.gashe.galeryslider.Adapters.GaleryPageAdapter;
import com.gashe.galeryslider.R;
import com.gashe.galeryslider.Utils.ZoomOutPageTransformer;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Gashe on 27/3/17.
 */

public class DownloadImages extends AsyncTask<String, Void, Bitmap[]> {

    private Context context;

    public DownloadImages(Context context) {
        this.context = context;
    }

    @Override
    protected Bitmap[] doInBackground(String... strings) {
        Bitmap[] bitmap = new Bitmap[strings.length];
        String url_image = null;
        URL object_url = null;
        HttpURLConnection http = null;
        int response = -5;
        InputStream inputStream = null;

        try {

            for(int i = 0; i < strings.length; i++) {

                url_image = strings[i];
                object_url = new URL(url_image);
                http = (HttpURLConnection) object_url.openConnection();

                response = http.getResponseCode();
                if (response == HttpURLConnection.HTTP_OK) {
                    inputStream = http.getInputStream();
                    bitmap[i] = BitmapFactory.decodeStream(inputStream);
                } else {
                    Log.d("MENSAJE", "Algo fue mal");
                }

            }

        }catch (Throwable t){
            Log.d("MENSAJE", "Algo fue mal" + t);

        }finally {
            http.disconnect();
        }


        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap[] bitmap) {
        Log.d("MENSAJE", "TODO DESCARGADO");

        GaleryActivity activity = (GaleryActivity)context;

        LinearLayout linearLayout = (LinearLayout)activity.findViewById(R.id.linearLayoutLoader);
        for ( int i = 0; i < linearLayout.getChildCount();  i++ ){
            View view = linearLayout.getChildAt(i);
            view.setVisibility(View.GONE);
        }

        ViewPager viewPager = (ViewPager)activity.findViewById(R.id.viewPagerGalery);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

        GaleryPageAdapter galeryPageAdapter = new GaleryPageAdapter(activity.getSupportFragmentManager(), bitmap);
        viewPager.setAdapter(galeryPageAdapter);

        super.onPostExecute(bitmap);
    }

}
