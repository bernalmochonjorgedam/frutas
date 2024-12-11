package com.naxer.almacenimiento.segundaParte.room;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;
import com.naxer.almacenimiento.model.Fruta;
import com.naxer.almacenimiento.model.Nutrition;
import com.naxer.almacenimiento.segundaParte.dao.FrutaDao;
import com.naxer.almacenimiento.segundaParte.dao.NutritionDao;

@Database(entities = {Fruta.class, Nutrition.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FrutaDao frutaDao();

    public abstract NutritionDao nutritionDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "frutas_database_tres")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

