package com.naxer.almacenimiento.segundaParte.dao;

import androidx.room.*;
import com.naxer.almacenimiento.model.Fruta;
import com.naxer.almacenimiento.model.Nutrition;

import java.util.List;

@Dao
public interface FrutaDao {
    @Insert
    List<Long> insertAll(List<Fruta> frutas);

    @Insert
    void insert(Nutrition nutrition);

    @Transaction
    default void insertFrutasYNutricion(List<Fruta> frutas, List<Nutrition> nutriciones) {
        List<Long> ids = insertAll(frutas);
        for (int i = 0; i < frutas.size(); i++) {
            long frutaId = ids.get(i);
            Nutrition nutrition = nutriciones.get(i);
            nutrition.setIdFruit(frutaId); // Asegúrate de que Nutrition tenga este método
            insert(nutrition);
        }
    }

    @Query("SELECT * FROM fruta")
    List<Fruta> getAllFrutas();

    @Query("SELECT * FROM fruta WHERE id = :fruitId")
    Fruta getFrutaById(int fruitId);
}
