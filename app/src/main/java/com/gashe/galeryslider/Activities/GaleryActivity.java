package com.gashe.galeryslider.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gashe.galeryslider.Utils.DownloadImages;
import com.gashe.galeryslider.R;

public class GaleryActivity extends AppCompatActivity {

    private int position;
    private static final String[][] URLS = new String[][]{
            new String[]{
                    "http://img.rtve.es/i/?w=1000&crop=no&o=no&i=1490464161019.jpg",
                    "http://ep00.epimg.net/deportes/imagenes/2016/04/11/actualidad/1460327418_245461_1460327849_noticia_normal.jpg",
                    "https://s-media-cache-ak0.pinimg.com/736x/4c/6f/a7/4c6fa787e42c2b01f9b19dd292435581.jpg",
                    "http://www.tnrelaciones.com/cm/preguntas_y_respuestas/images/Image/Deportistas%20Leo/Usain-Bolt-Signo-del-Zodiaco-Leo-2.jpg",
                    "http://zcodesystem.com/blogespanol/wp-content/uploads/2015/03/Zcode-guru-apuestas-deportivas-Eurocopa-2016.jpg"
            },
            new String[]{
                    "http://media.salir-static.net/_images_/peliculas/8/f/6/2/cartel_el_senor_de_los_anillos_el_retorno_del_rey_0.jpg",
                    "http://cdn23.paredro.com/wp-content/uploads/2015/06/cartel-cine9.jpg",
                    "https://s-media-cache-ak0.pinimg.com/564x/93/e0/82/93e0823ca1bcf80b83d65699e7a891d7.jpg",
                    "http://precriticas.s3.amazonaws.com/archivos_imagenes_carteles_c_crystalskullposter-big.jpg",
                    "http://es.ubergizmo.com/wp-content/uploads/2016/10/logan-623x800.png"
            },
            new String[]{
                    "http://media4.s-nbcnews.com/j/newscms/2016_04/951851/ss-121226-leonardo-dicaprio-5-nbcnews-ux-1024-900_8aac41293789b0c0b66c91cb8d098f04.today-ss-slide-desktop.jpg",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8d/President_Barack_Obama.jpg/1200px-President_Barack_Obama.jpg",
                    "https://s-media-cache-ak0.pinimg.com/736x/d3/7b/9a/d37b9a477a72c2ee6c45d29c589d7763.jpg",
                    "http://imworld.aufeminin.com/story/20141120/jordi-hurtado-57-543612_w650.jpg",
                    "http://www.revistamactoday.com/wp-content/uploads/2012/05/iker1.jpg"
            },
            new String[]{
                    "https://s-media-cache-ak0.pinimg.com/736x/83/d4/88/83d4880d2135616098f6808f09383b29.jpg",
                    "https://s-media-cache-ak0.pinimg.com/736x/57/9c/b4/579cb4f5d2fa440552b203089cf2eb79.jpg",
                    "https://s-media-cache-ak0.pinimg.com/736x/38/eb/1d/38eb1da2dd2dd943aa7babb10d6123d6.jpg",
                    "https://s-media-cache-ak0.pinimg.com/736x/8c/70/70/8c7070fa0bf9b61c50b28e3d959912da.jpg",
                    "https://s-media-cache-ak0.pinimg.com/736x/a3/2a/78/a32a7848823def9a01fc0060641ed324.jpg"
            }
    };

    private Bitmap[] BITMAPS;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galery);

        Intent intent = getIntent();
        position = intent.getIntExtra("position", 0);

        DownloadImages downloadImages = new DownloadImages(this);
        downloadImages.execute(URLS[position]);

    }


}
