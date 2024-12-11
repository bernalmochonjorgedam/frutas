package com.naxer.almacenimiento.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.naxer.almacenimiento.DetalleActivityTwo;
import com.naxer.almacenimiento.R;
import com.naxer.almacenimiento.model.Fruta;

import java.util.List;


public class FrutaAdapter extends RecyclerView.Adapter<FrutaAdapter.ViewHolder> {
    private List<Fruta> frutas;
    private Context context;

    public FrutaAdapter(List<Fruta> frutas, Context context) {
        this.frutas = frutas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fruta, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruta fruta = frutas.get(position);
        holder.nombre.setText(fruta.getNombre());
        holder.familia.setText(fruta.getFamilia());

        holder.nombre.setTypeface(null, Typeface.BOLD);
        holder.nombre.setTextColor(Color.BLACK);
        holder.familia.setTextColor(Color.DKGRAY);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetalleActivityTwo.class);
            intent.putExtra("fruta_id", holder.getAdapterPosition());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return frutas.size();
    }

    public void updateFruits(List<Fruta> frutas) {
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre;
        TextView familia;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre);
            familia = itemView.findViewById(R.id.familia);
        }
    }
}