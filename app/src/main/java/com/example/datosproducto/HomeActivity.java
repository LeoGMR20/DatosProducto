package com.example.datosproducto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeActivity extends AppCompatActivity {

    //Atributos

    private ArrayList<String> opciones;

    //Componentes visuales

    private TextView txtResultado;
    private Spinner spOpciones;
    private Button btnProcesar;

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
        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasarOtraPantalla();
            }
        });
    }

    private void inicializarVistas() {
        txtResultado = findViewById(R.id.txtResultado);
        spOpciones = findViewById(R.id.spOpciones);
        btnProcesar = findViewById(R.id.btnProcesar);
    }

    private void mostrarDatos() {
        txtResultado.setText(producto.toString());
    }

    private void popularSpinner() {
        opciones = new ArrayList<>(Arrays.asList("Valoración media","Comprar producto"));
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

    private void pasarOtraPantalla() {
        Intent intencion;
        String opcionSeleccionada = spOpciones.getSelectedItem().toString();
        switch (opcionSeleccionada){
            case "Valoración media":{
                intencion = new Intent(this,ValoracionMediaActivity.class);
                startActivity(intencion);
            }
            break;
            case "Comprar producto":{
                intencion = new Intent(this,DetalleFacturaActivity.class);
                Bundle archivoTemporal = new Bundle();
                archivoTemporal.putSerializable("objeto_producto2",producto);
                intencion.putExtras(archivoTemporal);
                startActivity(intencion);
            }
            break;
            default:
                Toast.makeText(this,"Seleccione una opción válida",Toast.LENGTH_LONG).show();
                break;
        }
    }
}