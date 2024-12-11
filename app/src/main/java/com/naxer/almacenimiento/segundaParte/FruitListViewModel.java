package com.naxer.almacenimiento.segundaParte;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.naxer.almacenimiento.model.Fruta;
import com.naxer.almacenimiento.model.Nutrition;
import com.naxer.almacenimiento.segundaParte.dao.FrutaDao;
import com.naxer.almacenimiento.segundaParte.dao.NutritionDao;
import com.naxer.almacenimiento.segundaParte.room.AppDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FruitListViewModel extends AndroidViewModel {
    private final MutableLiveData<List<Fruta>> frutasLiveData = new MutableLiveData<>();
    private final FrutaDao frutaDao;
    private final NutritionDao nutritionDao;

    // Executor para tareas en segundo plano
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public FruitListViewModel(@NonNull Application application) {
        super(application);
        AppDatabase db = AppDatabase.getDatabase(application);
        frutaDao = db.frutaDao();
        nutritionDao = db.nutritionDao();
    }

    public LiveData<List<Fruta>> getFrutasLiveData() {
        return frutasLiveData;
    }

    public void loadFrutas() {
        executor.execute(() -> {
            List<Fruta> frutas = frutaDao.getAllFrutas();

            if (frutas.isEmpty()) {
                Log.i("load", "Generando frutas aleatorias");
                generarFrutasAleatorias(500);
                frutas = frutaDao.getAllFrutas();  // Recargar frutas después de generar
            }
            frutasLiveData.postValue(frutas);
        });
    }

    private void generarFrutasAleatorias(int cantidad) {
        Log.d("prueba", "Generando frutas aleatorias");
        Random random = new Random();
        List<Fruta> listaFrutas = new ArrayList<>();
        List<Nutrition> listaNutriciones = new ArrayList<>();

        for (int i = 1; i <= cantidad; i++) {
            Fruta fruta = new Fruta("Fruta " + i, "Familia " + (i % 10), random.nextInt(20), random.nextInt(10), random.nextInt(100), random.nextInt(15), random.nextInt(10));
            listaFrutas.add(fruta);

            // Creación de nutrición al mismo tiempo
            Nutrition nutrition = new Nutrition(0, random.nextFloat() * 100, random.nextFloat() * 50, random.nextFloat() * 30, random.nextFloat() * 300, random.nextFloat() * 40);
            listaNutriciones.add(nutrition);
        }

        // Insertar frutas y nutriciones en una transacción
        frutaDao.insertFrutasYNutricion(listaFrutas, listaNutriciones);
    }
}
