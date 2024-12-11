package com.naxer.almacenimiento.segundaParte.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.naxer.almacenimiento.model.Nutrition;

import java.util.List;

@Dao
public interface NutritionDao {
    @Query("SELECT * FROM nutrition WHERE idFruit = :fruitId")
    List<Nutrition> getNutritionByFruitId(int fruitId);

    @Insert
    void insert(Nutrition nutrition); // Método para insertar una nutrición

    @Insert
    void insertAll(List<Nutrition> nutritionList); // Método para insertar múltiples nutriciones
}
