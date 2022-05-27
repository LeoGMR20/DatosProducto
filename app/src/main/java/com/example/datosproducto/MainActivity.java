package com.example.datosproducto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Atributos

    //Componentes visuales

    private EditText etCodProducto, etMarca, etDenominacion, etPrecio;
    private Button btnRegistrar;

    //Paso de parámetros

    private Producto producto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerInformacion();
            }
        });
    }

    private void inicializarVistas() {
        etCodProducto = findViewById(R.id.etCodProducto);
        etMarca = findViewById(R.id.etMarca);
        etDenominacion = findViewById(R.id.etDenominacion);
        etPrecio = findViewById(R.id.etPrecio);
        btnRegistrar = findViewById(R.id.btnRegistrar);
    }

    private void obtenerInformacion() {
        if(etCodProducto.getText().toString().isEmpty() || etDenominacion.getText().toString().isEmpty() ||
            etMarca.getText().toString().isEmpty() || etPrecio.getText().toString().isEmpty()){
            Toast.makeText(this,"Debe ingresar todos los datos",Toast.LENGTH_LONG).show();
        }
        else if(etCodProducto.getText().toString().length() < 3){
            Toast.makeText(this,"El código ingresado es demasiado pequeño",Toast.LENGTH_LONG).show();
        }
        else if(etMarca.getText().toString().length() < 3){
            Toast.makeText(this,"El nombre de la marca ingresado es demasiado pequeño",Toast.LENGTH_LONG).show();
        }
        else if(etDenominacion.getText().toString().length() < 3){
            Toast.makeText(this,"La denominación de la marca ingresada es demasiado pequeño",Toast.LENGTH_LONG).show();
        }
        else if(Integer.parseInt(etPrecio.getText().toString()) <= 0){
            Toast.makeText(this,"El precio ingresado es menor a 0, ingrese un precio mayor",Toast.LENGTH_LONG).show();
        }
        else {
            producto = new Producto(Integer.parseInt(etCodProducto.getText().toString()),
                    etMarca.getText().toString(),
                    etDenominacion.getText().toString(),
                    Float.parseFloat(etPrecio.getText().toString()));
            pasarOtraPantalla();
        }
    }

    private void pasarOtraPantalla() {
        Intent intencion = new Intent(this, HomeActivity.class);
        Bundle archivoTemporal = new Bundle();
        archivoTemporal.putSerializable("objeto_producto",producto);
        intencion.putExtras(archivoTemporal);
        startActivity(intencion);
    }
}