package es.ieslavereda.myweather;


import java.util.ArrayList;
import java.util.List;

import es.ieslavereda.myweather.activities.Place;

public class Parameters {

    public final static String URL = "https://api.openweathermap.org/data/2.5/";
    public final static String API = "571de3fad30f1b0f6c30413b1f3385fd";
    public final static String ICON_URL_PRE = "http://openweathermap.org/img/wn/";
    public static final String ICON_URL_POST = "@2x.png";

    public static List<Place> placeList = new ArrayList<>();

    static {
        placeList.add(new Place("IES La Vereda","https://portal.edu.gva.es/lavereda/wp-content/uploads/sites/107/2022/12/FOTO-IES-LA-VEREDA.png",39.5862518f,-0.5423662f));
        placeList.add(new Place("Valencia","https://mundopositor.info/wp-content/uploads/2022/05/Ayuntamiento-de-Valencia.png",39.4077643f,-0.4315509f));
        placeList.add(new Place("Barcelona","https://fotos.hoteles.net/articulos/guia-barcelona-ciudad-2400-1.jpg",41.3926467f,2.0701496f));
        placeList.add(new Place("Madrid","https://soreco-group.com/wp-content/uploads/2022/06/madrid.png",40.4378698f,-3.8196191f));

    }

}
