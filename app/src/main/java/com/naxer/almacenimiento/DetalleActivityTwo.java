package com.naxer.almacenimiento;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.naxer.almacenimiento.model.Fruta;

public class DetalleActivityTwo extends AppCompatActivity {
    private TextView nombreTextView;
    private TextView familiaTextView;
    private TextView hidratosTextView;
    private TextView proteinasTextView;
    private TextView caloriasTextView;
    private TextView azucarTextView;
    private TextView grasaTextView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_two);

        // Habilitar la flecha de volver
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle("Detalles de la Fruta");
        }

        // Inicializar los TextViews
        nombreTextView = findViewById(R.id.nombre);
        familiaTextView = findViewById(R.id.familia);
        hidratosTextView = findViewById(R.id.hidratos);
        proteinasTextView = findViewById(R.id.proteinas);
        caloriasTextView = findViewById(R.id.calorias);
        azucarTextView = findViewById(R.id.azucar);
        grasaTextView = findViewById(R.id.grasa);

        int frutaId = getIntent().getIntExtra("fruta_id", -1);

        if (frutaId != -1) {
            Fruta fruta = ListadoActivity.frutas.get(frutaId);
            if (fruta != null) {
                nombreTextView.setText(fruta.getNombre());
                familiaTextView.setText(fruta.getFamilia());
                hidratosTextView.setText("Hidratos de carbono: " + fruta.getHidratos() + "g");
                proteinasTextView.setText("Proteínas: " + fruta.getProteinas() + "g");
                caloriasTextView.setText("Calorías: " + fruta.getCalorias() + " kcal");
                azucarTextView.setText("Azúcar: " + fruta.getAzucar() + "g");
                grasaTextView.setText("Grasa: " + fruta.getGrasa() + "g");
            }
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}