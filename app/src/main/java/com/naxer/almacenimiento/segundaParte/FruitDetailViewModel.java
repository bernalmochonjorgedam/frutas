package com.naxer.almacenimiento.segundaParte;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.naxer.almacenimiento.model.Fruta;
import com.naxer.almacenimiento.model.Nutrition;
import com.naxer.almacenimiento.segundaParte.dao.FrutaDao;
import com.naxer.almacenimiento.segundaParte.dao.NutritionDao;
import com.naxer.almacenimiento.segundaParte.room.AppDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FruitDetailViewModel extends AndroidViewModel {
    private final MutableLiveData<Fruta> fruitLiveData = new MutableLiveData<>();
    private final MutableLiveData<Nutrition> nutritionLiveData = new MutableLiveData<>();
    private final FrutaDao frutaDao;
    private final NutritionDao nutritionDao;

    // Executor para tareas en segundo plano
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public FruitDetailViewModel(@NonNull Application application) {
        super(application);
        AppDatabase db = AppDatabase.getDatabase(application);
        frutaDao = db.frutaDao();
        nutritionDao = db.nutritionDao();
    }

    public LiveData<Fruta> getFruitLiveData() {
        return fruitLiveData;
    }

    public LiveData<Nutrition> getNutritionLiveData() {
        return nutritionLiveData;
    }

    public void loadFruitById(int fruitId) {
        executor.execute(() -> {
            Fruta fruit = frutaDao.getFrutaById(fruitId);
            fruitLiveData.postValue(fruit);
            if (fruit != null) {
                loadNutritionByFruitId(fruitId);
            } else {
                nutritionLiveData.postValue(null); // O manejarlo como consideres
            }
        });
    }

    public void loadNutritionByFruitId(int fruitId) {
        executor.execute(() -> {
            List<Nutrition> nutritionList = nutritionDao.getNutritionByFruitId(fruitId);
            if (!nutritionList.isEmpty()) {
                nutritionLiveData.postValue(nutritionList.get(0));
            } else {
                nutritionLiveData.postValue(null); // O manejarlo de otra manera
            }
        });
    }
}
