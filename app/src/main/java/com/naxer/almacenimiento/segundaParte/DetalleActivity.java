package com.naxer.almacenimiento.segundaParte;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.naxer.almacenimiento.R;
import com.naxer.almacenimiento.model.Fruta;
import android.widget.TextView;
import com.naxer.almacenimiento.model.Nutrition;

public class DetalleActivity extends AppCompatActivity {
    private FruitDetailViewModel fruitDetailViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        int fruitId = getIntent().getIntExtra("fruit_id", -1);
        fruitDetailViewModel = new ViewModelProvider(this).get(FruitDetailViewModel.class);

        fruitDetailViewModel.getFruitLiveData().observe(this, fruit -> {
            if (fruit != null) {
                displayFruitDetails(fruit);
            } else {
                // Manejo de error, si no se encuentra la fruta
            }
        });

        fruitDetailViewModel.getNutritionLiveData().observe(this, nutrition -> {
            if (nutrition != null) {
                updateNutritionDetails(nutrition);
            } else {
                displayNoNutritionAvailable();
            }
        });

        fruitDetailViewModel.loadFruitById(fruitId);
    }

    private void displayFruitDetails(Fruta fruit) {
        TextView nombreTextView = findViewById(R.id.nombreTextView);
        TextView familiaTextView = findViewById(R.id.familiaTextView);
        nombreTextView.setText("Nombre: " + fruit.getNombre());
        familiaTextView.setText("Familia: " + fruit.getFamilia());
    }

    private void updateNutritionDetails(Nutrition nutrition) {
        TextView hidratosTextView = findViewById(R.id.hidratosTextView);
        TextView proteinasTextView = findViewById(R.id.proteinasTextView);
        TextView caloriasTextView = findViewById(R.id.caloriasTextView);
        TextView azucarTextView = findViewById(R.id.azucarTextView);
        TextView grasaTextView = findViewById(R.id.grasaTextView);

        hidratosTextView.setText("Hidratos: " + nutrition.getCarbohydrates());
        proteinasTextView.setText("Proteínas: " + nutrition.getProtein());
        caloriasTextView.setText("Calorías: " + nutrition.getCalories());
        azucarTextView.setText("Azúcar: " + nutrition.getSugar());
        grasaTextView.setText("Grasa: " + nutrition.getFat());
    }

    private void displayNoNutritionAvailable() {
        TextView hidratosTextView = findViewById(R.id.hidratosTextView);
        TextView proteinasTextView = findViewById(R.id.proteinasTextView);
        TextView caloriasTextView = findViewById(R.id.caloriasTextView);
        TextView azucarTextView = findViewById(R.id.azucarTextView);
        TextView grasaTextView = findViewById(R.id.grasaTextView);

        hidratosTextView.setText("Hidratos: No disponible");
        proteinasTextView.setText("Proteínas: No disponible");
        caloriasTextView.setText("Calorías: No disponible");
        azucarTextView.setText("Azúcar: No disponible");
        grasaTextView.setText("Grasa: No disponible");
    }
}
