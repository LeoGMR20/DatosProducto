package com.example.datosproducto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeActivity extends AppCompatActivity {

    //Atributos

    private ArrayList<String> opciones;

    //Componentes visuales

    private TextView txtResultado;
    private Spinner spOpciones;

    //Paso de parámetros

    private Producto producto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        inicializarVistas();
        recibirDatosPantallaA();
        mostrarDatos();
        popularSpinner();
    }

    private void inicializarVistas() {
        txtResultado = findViewById(R.id.txtResultado);
        spOpciones = findViewById(R.id.spOpciones);
    }

    private void mostrarDatos() {
        txtResultado.setText(producto.toString());
    }

    private void popularSpinner() {
        opciones = new ArrayList<>(Arrays.asList("Escoja una opción","Valoración media","Comprar producto"));
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                opciones
        );
        spOpciones.setAdapter(adaptador);
    }

    private void recibirDatosPantallaA(){
        producto = (Producto) this.getIntent().getExtras().getSerializable("objeto_producto");
    }
}