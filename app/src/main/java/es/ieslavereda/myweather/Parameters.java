package es.ieslavereda.myweather;


import java.util.ArrayList;
import java.util.List;

import es.ieslavereda.myweather.activities.Place;

public class Parameters {

    public final static String URL = "https://api.openweathermap.org/data/2.5/";
    public final static String API = "571de3fad30f1b0f6c30413b1f3385fd";
    public final static String ICON_URL = "http://openweathermap.org/img/wn/";

    public static List<Place> placeList = new ArrayList<>();
    static {
        placeList.add(new Place("Valencia","https://phantom-elmundo.unidadeditorial.es/2959d66274f76ba77c5fd314344e7d66/crop/2x0/3072x2047/resize/473/f/webp/assets/multimedia/imagenes/2022/02/22/16455200722788.jpg",39.4077643f,-0.4315509f));
        placeList.add(new Place("Barcelona","https://fotos.hoteles.net/articulos/guia-barcelona-ciudad-2400-1.jpg",41.3926467f,2.0701496f));
        placeList.add(new Place("Madrid","https://s03.s3c.es/imag/_v0/770x420/f/7/a/madrid-centro-coches-dreamstime.jpg",40.4378698f,-3.8196191f));
    }

}
