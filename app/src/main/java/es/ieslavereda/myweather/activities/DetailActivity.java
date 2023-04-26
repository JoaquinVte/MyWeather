package es.ieslavereda.myweather.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import es.ieslavereda.myweather.Parameters;
import es.ieslavereda.myweather.R;
import es.ieslavereda.myweather.base.ImageDownloader;

public class DetailActivity extends AppCompatActivity {

    Root root;
    int position;
    private TextView textViewDate;
    private TextView textViewTemp;
    private TextView textViewMax;
    private TextView textViewMin;
    private TextView textViewWindSpeed;
    private TextView textViewHumidity;
    private TextView textViewSeaLevel;
    private TextView textViewPressure;

    private TextView textViewDayOfWeek;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        root = (Root) intent.getExtras().getSerializable("root");
        position = intent.getExtras().getInt("position");

        imageView = findViewById(R.id.image);
        textViewDate  = findViewById(R.id.detailDay);
        textViewDayOfWeek = findViewById(R.id.detailDayOfWeek);
        textViewHumidity = findViewById(R.id.detailHumidity);
        textViewTemp = findViewById(R.id.detailTemp);
        textViewMax = findViewById(R.id.detailMax);
        textViewMin = findViewById(R.id.detailMin);
        textViewWindSpeed = findViewById(R.id.detailWindSpeed);
        textViewSeaLevel = findViewById(R.id.detailSeaLevel);
        textViewPressure = findViewById(R.id.detailPressure);


        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + root.list.get(position).weather.get(0).icon + Parameters.ICON_URL_POST,imageView);
        Date date = new Date((long)root.list.get(position).dt*1000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy",new Locale( GestionPreferencias.getInstance().getIdioma(getApplicationContext()) , GestionPreferencias.getInstance().getIdioma(getApplicationContext()).toUpperCase() ));
        String stringDay= dateFormat.format(date);

        textViewDate.setText(stringDay);
        textViewDayOfWeek.setText(new SimpleDateFormat("EEEE",new Locale( GestionPreferencias.getInstance().getIdioma(getApplicationContext()) , GestionPreferencias.getInstance().getIdioma(getApplicationContext()).toUpperCase() )).format(date).toUpperCase());
        textViewTemp.setText(root.list.get(position).main.temp+"º");
        textViewMax.setText(root.list.get(position).main.temp_max+"º");
        textViewMin.setText(root.list.get(position).main.temp_min+"º");
        textViewWindSpeed.setText(root.list.get(position).wind.speed+" m/s");
        textViewHumidity.setText(root.list.get(position).main.humidity+"%");
        textViewSeaLevel.setText(root.list.get(position).main.sea_level+"hPa");
        textViewPressure.setText(root.list.get(position).main.pressure+"hPa");

    }
    public void close(View v){
        finish();
    }
}