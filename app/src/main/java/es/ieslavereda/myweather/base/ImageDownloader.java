package es.ieslavereda.myweather.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import es.ieslavereda.myweather.R;

public class ImageDownloader {

    private static RequestQueue colaPeticiones ;

    public static void DownloadImage(Context context, String url, ImageView imageView){
        Picasso.get().load(url).into(imageView);
//        ImageRequest peticion = new ImageRequest(
//                url,
//                new Response.Listener<Bitmap>() {
//                    @Override public void onResponse(Bitmap bitmap) {
//                        imageView.setImageBitmap(bitmap);
//                    }
//                }, 0, 0, null, // maxWidth, maxHeight, decodeConfig
//                new Response.ErrorListener() {
//                    @Override public void onErrorResponse(VolleyError error) {
//                        imageView.setImageResource(R.drawable.ic_launcher_background);
//                        Log.e("ImageDowloader",error.getMessage());
//                    }
//                }
//        );
//        getRequestQueue(context).add(peticion);
    }

    private static RequestQueue getRequestQueue(Context context){
        if(colaPeticiones==null)
            colaPeticiones = Volley.newRequestQueue(context);
        return colaPeticiones;
    }




}
