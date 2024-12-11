package com.naxer.almacenimiento.segundaParte.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.naxer.almacenimiento.R;
import com.naxer.almacenimiento.model.Fruta;

import java.util.ArrayList;
import java.util.List;

import static com.naxer.almacenimiento.R.layout.item_fruit_two;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {
    private final OnFruitClickListener listener;
    private List<Fruta> frutas = new ArrayList<>();

    public FruitAdapter(OnFruitClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(item_fruit_two, parent, false);
        return new FruitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {
        Fruta fruta = frutas.get(position);
        holder.bind(fruta, listener);
    }

    @Override
    public int getItemCount() {
        return frutas.size();
    }

    public void setFrutas(List<Fruta> frutas) {
        this.frutas = frutas;
        notifyDataSetChanged();
    }

    public Fruta getFruitAtPosition(int position) {
        return frutas.get(position);
    }

    public interface OnFruitClickListener {
        void onFruitClick(int position);
    }

    static class FruitViewHolder extends RecyclerView.ViewHolder {
        private final TextView nombreTextView;

        public FruitViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.text_view_nombre);
        }

        public void bind(Fruta fruta, OnFruitClickListener listener) {
            nombreTextView.setText(fruta.getNombre());
            itemView.setOnClickListener(v -> listener.onFruitClick(getAdapterPosition()));
        }
    }
}
