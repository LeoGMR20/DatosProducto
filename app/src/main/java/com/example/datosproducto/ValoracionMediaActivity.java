package com.example.datosproducto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ValoracionMediaActivity extends AppCompatActivity {

    //Componentes Visuales

    private TextView tvValoMed, tvConsignaServ, tvPuntuacion;
    private Switch swReclamo;
    private EditText etReclamo;
    private Button btnCalcularValoracion;

    //atributos

    private boolean marcado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valoracion_media);
        inicializarVistas();
        btnCalcularValoracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularValoracion();
            }
        });
        swReclamo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                marcado = b;
                habilitarEtReclamo(b);
            }
        });
    }

    private void inicializarVistas() {
        tvValoMed = findViewById(R.id.tvValoMed);
        tvConsignaServ = findViewById(R.id.tvConsignaServ);
        tvPuntuacion = findViewById(R.id.tvPuntuacion);
        swReclamo = findViewById(R.id.swReclamo);
        etReclamo = findViewById(R.id.etReclamo);
        btnCalcularValoracion = findViewById(R.id.btnCalcularValoracion);
    }

    private void calcularValoracion() {
        Random random = new Random();
        int numRandom;
        if(marcado){
            numRandom = random.nextInt(3);
        }
        else{
            numRandom = ThreadLocalRandom.current().nextInt(3,6);
        }
        tvPuntuacion.setText("Puntuación\n"+numRandom+" / 5");
    }

    private void habilitarEtReclamo(boolean habilitado) {
        etReclamo.setEnabled(habilitado);
        if(!habilitado){
            etReclamo.getText().clear();
        }
    }
}
