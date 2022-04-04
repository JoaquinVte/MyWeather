package es.ieslavereda.myweather.activities;

import java.io.Serializable;

public class Place implements Serializable {
    private String name;
    private String image_url;
    private float lat;
    private float lon;

    public Place(String name, String image_url, float lat, float lon) {
        this.name = name;
        this.image_url = image_url;
        this.lat = lat;
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }

    public String getImage_url() {
        return image_url;
    }

    @Override
    public String toString() {
        return  name ;
    }
}
