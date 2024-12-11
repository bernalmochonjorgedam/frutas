package com.naxer.almacenimiento;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.naxer.almacenimiento.adapter.FrutaAdapter;
import com.naxer.almacenimiento.model.Fruta;

import java.util.*;

public class ListadoActivity extends AppCompatActivity {
    private FrutaAdapter adapter;
    public static List<Fruta> frutas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        Button buttonLoadFruits = findViewById(R.id.buttonLoadFruits);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                ((LinearLayoutManager) Objects.requireNonNull(recyclerView.getLayoutManager())).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        frutas = new ArrayList<>();
        adapter = new FrutaAdapter(frutas, this);
        recyclerView.setAdapter(adapter);

        buttonLoadFruits.setOnClickListener(v -> {
            loadFruits();
            buttonLoadFruits.setEnabled(false);
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    private void loadFruits() {
        if (frutas.isEmpty()) {
            frutas.add(new Fruta("Manzana", "Rosaceae", 150, 25, 0, 52, 10));
            frutas.add(new Fruta("Plátano", "Musaceae", 120, 27, 1, 89, 14));
            adapter.notifyDataSetChanged();
        }
    }
}