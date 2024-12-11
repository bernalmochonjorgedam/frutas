package com.naxer.almacenimiento.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Fruta {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nombre;
    private String familia;
    private int hidratos;
    private int proteinas;
    private int calorias;
    private int azucar;
    private int grasa;

    public Fruta() {
    }

    public Fruta(String nombre, String familia, int hidratos, int proteinas, int calorias, int azucar, int grasa) {
        this.nombre = nombre;
        this.familia = familia;
        this.hidratos = hidratos;
        this.proteinas = proteinas;
        this.calorias = calorias;
        this.azucar = azucar;
        this.grasa = grasa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public int getHidratos() {
        return hidratos;
    }

    public void setHidratos(int hidratos) {
        this.hidratos = hidratos;
    }

    public int getProteinas() {
        return proteinas;
    }

    public void setProteinas(int proteinas) {
        this.proteinas = proteinas;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public int getAzucar() {
        return azucar;
    }

    public void setAzucar(int azucar) {
        this.azucar = azucar;
    }

    public int getGrasa() {
        return grasa;
    }

    public void setGrasa(int grasa) {
        this.grasa = grasa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNutrition(Nutrition nutrition) {
    }
}

