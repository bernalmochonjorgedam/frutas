package com.naxer.almacenimiento.segundaParte;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.naxer.almacenimiento.R;
import com.naxer.almacenimiento.model.Fruta;
import com.naxer.almacenimiento.segundaParte.adapter.FruitAdapter;
import androidx.recyclerview.widget.*;


public class MainActivity extends AppCompatActivity implements FruitAdapter.OnFruitClickListener {
    private FruitListViewModel viewModel;
    private FruitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FruitAdapter(this);
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(FruitListViewModel.class);
        viewModel.getFrutasLiveData().observe(this, frutas -> {
            if (frutas != null) {
                adapter.setFrutas(frutas);
            } else {
                // Manejo de error, si no se cargan frutas
            }
        });

        Button cargarButton = findViewById(R.id.button_cargar);
        cargarButton.setOnClickListener(v -> viewModel.loadFrutas());
    }

    @Override
    public void onFruitClick(int position) {
        Fruta clickedFruit = adapter.getFruitAtPosition(position);
        Intent intent = new Intent(this, DetalleActivity.class);
        intent.putExtra("fruit_id", clickedFruit.getId());
        startActivity(intent);
    }
}
