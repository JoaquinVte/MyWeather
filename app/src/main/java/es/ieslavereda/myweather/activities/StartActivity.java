package es.ieslavereda.myweather.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import es.ieslavereda.myweather.Parameters;
import es.ieslavereda.myweather.R;
import es.ieslavereda.myweather.base.ImageDownloader;

public class StartActivity extends AppCompatActivity {

    private Spinner spinner;
    private ImageView imagePlace;
    private Button prevision;
    private Place place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        spinner = findViewById(R.id.spinner);
        imagePlace = findViewById(R.id.imagePlace);
        prevision = findViewById(R.id.prevision);

        ArrayAdapter<Place> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Parameters.placeList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                place = adapter.getItem(i);
                ImageDownloader.DownloadImage(getApplicationContext(),place.getImage_url(), imagePlace);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner.setAdapter(adapter);

        prevision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),PrevisionActivity.class);
                intent.putExtra("place" , place);
                startActivity(intent);
            }
        });
    }
}