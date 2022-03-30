package es.ieslavereda.myweather.activities;

import static es.ieslavereda.myweather.Parameters.API;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.ieslavereda.myweather.Parameters;
import es.ieslavereda.myweather.R;
import es.ieslavereda.myweather.api.Connector;
import es.ieslavereda.myweather.base.BaseActivity;
import es.ieslavereda.myweather.base.CallInterface;


public class MainActivity extends BaseActivity implements CallInterface, View.OnClickListener {

    private Root root;
    private RecyclerView recyclerView;
    private List<es.ieslavereda.myweather.activities.List> datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(R.layout.activity_main);

        datos = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler);

        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(this,datos);
        myRecyclerViewAdapter.setOnClickListener(this);
        recyclerView.setAdapter(myRecyclerViewAdapter);

        LinearLayoutManager myLinearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(myLinearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, RecyclerView.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    protected void onResume() {
        super.onResume();
        executeCall(this);
    }

    @Override
    public void doInBackground() {
        showProgress();
        root = Connector.getConector().get(Root.class,"forecast?lang=es&units=metric&lat=39&lon=-0.5&appid="+ API);
    }

    @Override
    public void doInUI() {
        hideProgress();
        datos.addAll(root.list);
    }

    @Override
    public void onClick(View v) {

    }
}