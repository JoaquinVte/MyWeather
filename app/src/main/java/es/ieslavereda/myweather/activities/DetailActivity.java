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
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        root = (Root) intent.getExtras().getSerializable("root");
        position = intent.getExtras().getInt("position");

        imageView = findViewById(R.id.image);
        textViewDate  = findViewById(R.id.date);

        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + root.list.get(position).weather.get(0).icon + Parameters.ICON_URL_POST,imageView);
        Date date = new Date((long)root.list.get(position).dt*1000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd/MM/yyyy hh:mm",new Locale( "es" , "ES" ));
        String stringDay= dateFormat.format(date);

        textViewDate.setText(stringDay);
    }
    public void close(View v){
        finish();
    }
}