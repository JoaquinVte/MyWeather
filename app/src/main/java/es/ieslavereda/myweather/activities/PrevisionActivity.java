package es.ieslavereda.myweather.activities;

import static es.ieslavereda.myweather.Parameters.API;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.ieslavereda.myweather.R;
import es.ieslavereda.myweather.api.Connector;
import es.ieslavereda.myweather.base.BaseActivity;
import es.ieslavereda.myweather.base.CallInterface;


public class PrevisionActivity extends BaseActivity implements CallInterface, View.OnClickListener {

    private static final String TAG = PrevisionActivity.class.getName();

    private Root root;
    private RecyclerView recyclerView;
    private List<es.ieslavereda.myweather.activities.List> datos;
    private Place place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(R.layout.activity_prevision);

        if( getIntent().getExtras() != null) {

            place = (Place) getIntent().getExtras().getSerializable("place");

            datos = new ArrayList<>();
            recyclerView = findViewById(R.id.recycler);
            TextView ciudad = findViewById(R.id.ciudad);

            ciudad.setText(place.getName());

            recyclerView.setOnClickListener(this);
            MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(this, datos);
            myRecyclerViewAdapter.setOnClickListener(this);
            recyclerView.setAdapter(myRecyclerViewAdapter);

            LinearLayoutManager myLinearLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(myLinearLayoutManager);

            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, RecyclerView.VERTICAL);
            recyclerView.addItemDecoration(dividerItemDecoration);

        } else {
            Toast.makeText(this,"No se ha seleccionado ninguna ciudad",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        showProgress();
        executeCall(this);
    }

    @Override
    public void doInBackground() {
        String url = "forecast?lang=es&units=metric&lat="+ place.getLat() + "&lon="+ place.getLon() +"&appid="+ API;
        Log.d(TAG, url);
        root = Connector.getConector().get(Root.class,url);
    }

    @Override
    public void doInUI() {
        hideProgress();
        datos.addAll(root.list);
    }

    @Override
    public void onClick(View view) {
        int position = recyclerView.getChildAdapterPosition(view);
        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra("root",root);
        intent.putExtra("position",position);
        startActivity(intent);
    }
}