package com.naxer.almacenimiento.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "nutrition",
        foreignKeys = @ForeignKey(
                entity = Fruta.class,
                parentColumns = "id",
                childColumns = "idFruit",
                onDelete = ForeignKey.CASCADE
        )
)

public class Nutrition {
    @PrimaryKey(autoGenerate = true)
    private long id; // Clave primaria
    private long idFruit; // Clave foránea que referencia a la fruta

    private float carbohydrates;
    private float protein;
    private float calories;
    private float sugar;
    private float fat;

    // Constructor
    public Nutrition(long idFruit, float carbohydrates, float protein, float calories, float sugar, float fat) {
        this.idFruit = idFruit;
        this.carbohydrates = carbohydrates;
        this.protein = protein;
        this.calories = calories;
        this.sugar = sugar;
        this.fat = fat;
    }

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdFruit() {
        return idFruit;
    }

    public void setIdFruit(long idFruit) {
        this.idFruit = idFruit;
    }

    public float getCarbohydrates() {
        return carbohydrates;
    }

    public float getProtein() {
        return protein;
    }

    public float getCalories() {
        return calories;
    }

    public float getSugar() {
        return sugar;
    }

    public float getFat() {
        return fat;
    }
}
